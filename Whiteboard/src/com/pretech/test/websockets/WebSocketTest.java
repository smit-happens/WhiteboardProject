package com.pretech.test.websockets;
import org.apache.commons.lang3.StringUtils;

import model.AccountDO;
import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

import java.io.IOException;
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
			String email = StringUtils.substringBefore(commandData, "|"); // email
			String password = StringUtils.substringAfter(commandData, "|"); // password
			AccountDO accountDO = new AccountDO();
			accountDO = db.getAccountbyEmail(email); // null if invalid account
			Account account = null;
			if(accountDO != null){
				if(accountDO.getPassword()== password){ 
					account = whiteboard.getAccountbySessionID(session.getId());
					if(account.getMessageSender().getSessionId() != null){ // always check this
						if(whiteboard.getNumberOfAccounts()==1){ // only get the whiteboard for the first user to log on
							if(account.getMessageSender().getSessionId() != null){
								WhiteboardDO whiteboardDO= db.getWhiteboard(whiteboard.getName());
								// get all shapes from whiteboardDO and add them to the whiteboard
								whiteboard.
								
								// send out a messages to the user that opened the session of all the shapes in the whiteboard model
								
								// update the empty account with the login email and password information
							}

						}
						else{ // all other users
							// send out a messages to the user that opened the session of all the shapes in the whiteboard model
							
							// update the empty account with the login email and password information
						}
					}
					else{ // shouldnt get her! ids should match
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
			whiteboard.broadcastMessage(MessageCommand.Clear, "");
			String whiteboardName = whiteboard.getName();
			db.clearWhiteboard(whiteboardName);
			break;

		case "DeleteAccount": // commandData = email|
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
			String email2 = StringUtils.substringBefore(commandData, "|"); // email
			String password2 = StringUtils.substringAfter(commandData, "|"); // password
			MessageSender messageSender2 = new MessageSender(session);
			Account account2 = new Account(whiteboard, messageSender2);
			AccountDO accountDO2 = new AccountDO();
			accountDO2 = db.getAccountbyEmail(email2); // null if invalid account
			// add account into database
			if(accountDO2 == null){
				db.insertAccount(email2, password2, email2); // in this version username = email
			}
			else{
				account2.sendSingleAccountMessage(MessageCommand.AccountExists, "account already exists");
			}
			break;

		case "Logout": // commandData = email|
			// remove account from the server whiteboard model object
			String email3 = StringUtils.substringBefore(commandData, "|"); // email
			MessageSender messageSender3 = new MessageSender(session);
			Account account3 = new Account(whiteboard, messageSender3);
			account3.setName(email3); // remove account checks by name and in this version name = email
			whiteboard.removeAccount(account3);
			break;

		case "Update" :
			whiteboard.broadcastMessage(MessageCommand.Update, commandData);
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
				//for all the shapes- update both the whiteboard model and database model
			}
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
}
