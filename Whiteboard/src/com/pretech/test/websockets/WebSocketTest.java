package com.pretech.test.websockets;
import org.apache.commons.lang3.StringUtils;

import model.AccountDO;
import model.ShapeDO;
import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketTest {

	//static use here means one copy exists for all instances of that class.
	// This means all users share the same whiteboard object
	//The @ServerEndpoint annotion above indicate to Tomcat's websocket engine to
	//to create a thread and instance of the class for each @onOpen.  For milestone1,
	// whiteboard variable is not threadsafe (e.g. no locks to prevent 
	// simultaneous use)


	IDatabase db;
	private static Whiteboard whiteboard;

	/*private void setDB(){
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}*/

	Session session;

	public WebSocketTest() {
		this.whiteboard = new Whiteboard("CS 320 board");
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		//setDB();	
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException,
	InterruptedException {
		// Update | Circle | radius(#) | center X (#) | center Y (#) | girth(#) | color(#)
		//System.out.println(message);
		String command = StringUtils.substringBefore(message, "|");
		String commandData = StringUtils.substringAfter(message, "|");
		//System.out.println(commandData);

		switch (command) {

		case "Login"://command= Login|email|password; commandData = email|password
			System.out.println("Login" +commandData);
			String email = StringUtils.substringBefore(commandData, "|"); // email
			//String password = StringUtils.substringBefore(StringUtils.substringAfter(commandData, "|"),"|"); // password
			String password = StringUtils.substringAfter(commandData, "|"); // password
			System.out.println("email= " + email);
			System.out.println("password= "+ password);
			AccountDO accountDO = new AccountDO();
			accountDO = db.getAccountbyEmail(email); 
			System.out.println("accountDO.getPassword()= "+ accountDO.getPassword());
			int wbKey=0;
			Account account = whiteboard.getAccountbySessionID(session.getId());
			System.out.println("account.getMessageSender().getSessionId() = "+ account.getMessageSender().getSessionId() );
			WhiteboardDO whiteboardDO= db.getWhiteboard(whiteboard.getName());
			System.out.println("whiteboardDO.getShapeList().size()= "+ whiteboardDO.getShapeList().size());
			if(accountDO.getAccountKey() > 0){
				if(accountDO.getPassword().equals(password)){ 
					if(account.getMessageSender().getSessionId() != null){ // always check this
						if(whiteboard.getNumberOfAccounts()==1){ // only get the whiteboard for the first user to log on
							if(account.getMessageSender().getSessionId() != null){

								// get all shapes from whiteboardDO and add them to the whiteboard
								whiteboard.setShapeArrList(whiteboardDO.getShapeList());
								// send out a messages to the user that opened the session of all the shapes in the whiteboard model
								for(int i=0; i<whiteboardDO.getShapeList().size(); i++){
									ShapeDO shapeDO= whiteboardDO.getShapeList().get(i);
									String msg = shapeDO.getShapeString();
									account.sendSingleAccountMessage(MessageCommand.Update, msg);
									System.out.println("Shape message=  " + msg);
								}
								// update the empty account with the login email and password information
								account.setEmail(email);
								account.setPassword(password);
								account.setName(email);
								// send login successful message
								account.sendSingleAccountMessage(MessageCommand.LoginSuccessful, "LoginSuccessful");
								System.out.println("login successful");
							}

						}
						else{ // all other users
							
							// send out a messages to the user that opened the session of all the shapes in the whiteboard model
							for(int i=0; i<whiteboardDO.getShapeList().size(); i++){
								ShapeDO shapeDO= whiteboardDO.getShapeList().get(i);
								String msg = shapeDO.getShapeString();
								account.sendSingleAccountMessage(MessageCommand.Update, msg);
							}
							// update the empty account with the login email and password information
							account.setEmail(email);
							account.setPassword(password);
							account.setName(email);
							
							account.sendSingleAccountMessage(MessageCommand.LoginSuccessful, "LoginSuccessful");
							System.out.println("login successful");
						}
					}
					else{ // shouldnt get here! ids should match
						System.out.println(" ids do not match");

					}

				}
				else{
					//send invalid password message back to browser associated with user login
					account.sendSingleAccountMessage(MessageCommand.InvalidPassword, "invalid password");
				}
			}
			else{
				account.sendSingleAccountMessage(MessageCommand.InvalidEmailAccount, "invalid email account");
			}
			break;

		case "Clear":
			System.out.println("Clear" +commandData);
			whiteboard.broadcastMessage(MessageCommand.Clear, "");
			String whiteboardName = whiteboard.getName();
			db.clearWhiteboard(whiteboardName);
			break;

		case "DeleteAccount": // commandData = email|
			System.out.println("DeleteAccount" +commandData);
			// remove account from the server whiteboard model object
			String email1 = StringUtils.substringBefore(commandData, "|"); // email
			MessageSender messageSender1 = new MessageSender(session);
			Account account1 = new Account(whiteboard, messageSender1);
			account1.setName(email1); // remove account checks by name and in this version name = email
			whiteboard.removeAccount(account1);
			
			// remove account from database
			db.removeAccount(email1);
			break;

		case "CreateAccount": // commandData = email|password|
			System.out.println("CreateAccount|" +commandData);
			String email2 = StringUtils.substringBefore(commandData, "|"); // email
			String password2 = StringUtils.substringAfter(commandData, "|"); // password
			System.out.println("email " +email2);
			System.out.println("password " +password2);
			MessageSender messageSender2 = new MessageSender(session);
			Account account2 = new Account(whiteboard, messageSender2);
			AccountDO accountDO2 = new AccountDO();
			accountDO2 = db.getAccountbyEmail(email2); // null if invalid account
			// add account into database
			System.out.println("accountKey" +accountDO2.getAccountKey());
			if(accountDO2.getAccountKey() <= 0){
				Integer accountKey = db.insertAccount(email2, password2, email2); // in this version username = email
				System.out.println("inserted account");
				account2.sendSingleAccountMessage(MessageCommand.AccountCreated, "account successfully created");
			}
			else{
				System.out.println("account exists");
				account2.sendSingleAccountMessage(MessageCommand.AccountExists, "account already exists");
			}
			break;

		case "Logout": // commandData = email|
			
			System.out.println("Logout" +commandData);
			// remove account from the server whiteboard model object
			String email3 = StringUtils.substringBefore(commandData, "|"); // email
			MessageSender messageSender3 = new MessageSender(session);
			Account account3 = new Account(whiteboard, messageSender3);
			account3.setName(email3); // remove account checks by name and in this version name = email
			whiteboard.removeAccount(account3);
			break;


		case "Update" :
			System.out.println("Update" +commandData);
			// broadcast the update shape to all users connected
			whiteboard.broadcastMessage(MessageCommand.Update, commandData);

			//for any update message- update both the whiteboard model and database model
			int shapeKey= db.insertShape(commandData, whiteboard.getName());
			ShapeDO shapeDO= new ShapeDO();
			shapeDO.setShapeKey(shapeKey);
			shapeDO.setShapeString(commandData);
			List<ShapeDO> shapeDOList = whiteboard.getShapeArrList();
			shapeDOList.add(shapeDO);

			/*
			String shape = StringUtils.substringBefore(commandData, "|"); // circle
			String shapeData = StringUtils.substringAfter(commandData, "|"); // girth | color | point1x | point1y | point2x |point2y |
			//Integer shapeKey = db.insertShape(shapeData, "Cara's board");

			if(shape.equals("Freeform")){
				String[] freeformDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double girth = Double.parseDouble(freeformDataArrStr[0]); 
				String color = freeformDataArrStr[1];
				String[] pointsList= StringUtils.splitByWholeSeparatorPreserveAllTokens(freeformDataArrStr[2], ",");
				for(int i=0; i< pointsList.length; i=+2){
					int x1= Integer.parseInt(pointsList[i]);
					int y1= Integer.parseInt(pointsList[i+1]);
					Point point= new Point(x1, y1);
					// freeform.addPoint(point);
				}
			}*/
		
		
		break;
	}	
}

@OnOpen
public void onOpen(Session session) throws IOException {
	this.session = session;
	MessageSender messageSender = new MessageSender(session);
	Account account = whiteboard.createAndAddAccount(messageSender);


}

@OnClose
public void onClose(Session session) throws IOException {

	whiteboard.removeAccountBySessionId(this.session.getId());
	System.out.println("Connection closed");


}
public static void main(String[] args) throws Exception {
	DatabaseProvider.setInstance(new DerbyDatabase());
	IDatabase db = DatabaseProvider.getInstance();
}
}
