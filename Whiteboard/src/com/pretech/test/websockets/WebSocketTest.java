package com.pretech.test.websockets;
import org.apache.commons.lang3.StringUtils;
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
	private static Whiteboard whiteboard;
	
	Session session;
		
	public WebSocketTest() {
		this.whiteboard = new Whiteboard();
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException,
	InterruptedException {
		
		// Update | Circle | radius(#) | center X (#) | center Y (#) | girth(#) | color(#)
		System.out.println(message);
		String command = StringUtils.substringBefore(message, "|");
		String commandData = StringUtils.substringAfter(message, "|");
		System.out.println(commandData);
		
		switch (command) {
		
		case "Login":
			MessageSender messageSender = new MessageSender(session);
			Account account = whiteboard.createAndAddAccount(messageSender);
			break;
		case "Clear":
			whiteboard.broadcastMessage(MessageCommand.Clear, "");
			break;
			
		case "Redo" :
			whiteboard.broadcastMessage(MessageCommand.Redo, "");
			break;
			
		case "Undo" :
			whiteboard.broadcastMessage(MessageCommand.Undo, "");
			break;
			
		case "Update" :
			whiteboard.broadcastMessage(MessageCommand.Update, commandData);
			String shape = StringUtils.substringBefore(commandData, "|"); // circle
			String shapeData = StringUtils.substringAfter(commandData, "|"); // girth | color | point1x | point1y | point2x |point2y |
			
			if(shape.equals("Circle")){

				String[] circleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double girth = Double.parseDouble(circleDataArrStr[0]); 
				String color = circleDataArrStr[1];
				int X1 = Integer.parseInt(circleDataArrStr[2]);
				int Y1 = Integer.parseInt(circleDataArrStr[3]);
				int X2 = Integer.parseInt(circleDataArrStr[4]);
				int Y2 = Integer.parseInt(circleDataArrStr[5]);
			}
			// Update | Rectangle | girth | color | point1x | point1y | point2x |point2y
			if(shape.equals("Rectangle")){
				String[] rectangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double girth = Double.parseDouble(rectangleDataArrStr[0]); 
				String color = rectangleDataArrStr[1];
				int X1 = Integer.parseInt(rectangleDataArrStr[2]);
				int Y1 = Integer.parseInt(rectangleDataArrStr[3]);
				int X2 = Integer.parseInt(rectangleDataArrStr[4]);
				int Y2 = Integer.parseInt(rectangleDataArrStr[5]);
			}
			// Update | Triangle | girth | color | point1x | point1y | point2x |point2y
			if(shape.equals("Triangle")){
				String[] triangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double girth = Double.parseDouble(triangleDataArrStr[0]); 
				String color = triangleDataArrStr[1];
				int X1 = Integer.parseInt(triangleDataArrStr[2]);
				int Y1 = Integer.parseInt(triangleDataArrStr[3]);
				int X2 = Integer.parseInt(triangleDataArrStr[4]);
				int Y2 = Integer.parseInt(triangleDataArrStr[5]);
			}
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
	public void onClose() throws IOException {
		
		whiteboard.removeAccountBySessionId(this.session.getId());
		System.out.println("Connection closed");

		
	}
}
