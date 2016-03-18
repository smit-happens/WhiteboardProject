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
		
		switch (command) {
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
			String shapeData = StringUtils.substringAfter(commandData, "|"); // radius | center | girth | color
			
			if(shape.equals("Circle")){

				String[] circleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double radius = Double.parseDouble(circleDataArrStr[0]); 
				int centerX = Integer.parseInt(circleDataArrStr[1]);
				int centerY = Integer.parseInt(circleDataArrStr[2]);
				double girth = Double.parseDouble(circleDataArrStr[3]); 
				double color = Double.parseDouble(circleDataArrStr[4]);
				
			}
			// Update | Rectangle | topLeft X | topleft Y | width | height| girth(#) | color(#)
			if(shape.equals("Rectangle")){
				String[] rectangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				int topLeftX = Integer.parseInt(rectangleDataArrStr[0]); 
				int topLeftY = Integer.parseInt(rectangleDataArrStr[1]); 
				double width = Double.parseDouble(rectangleDataArrStr[2]); 
				double height = Double.parseDouble(rectangleDataArrStr[3]); 
				double girth = Double.parseDouble(rectangleDataArrStr[4]); 
				double color = Double.parseDouble(rectangleDataArrStr[5]); 
			}
			// Update | Triangle | top X | top Y | base | height| girth(#) | color(#)
			if(shape.equals("Triangle")){
				String[] triangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				int topX = Integer.parseInt(triangleDataArrStr[0]); 
				int topY = Integer.parseInt(triangleDataArrStr[1]);
				double base = Double.parseDouble(triangleDataArrStr[2]); 
				double height = Double.parseDouble(triangleDataArrStr[3]);
				double girth = Double.parseDouble(triangleDataArrStr[4]); 
				double color = Double.parseDouble(triangleDataArrStr[5]);
			}
			break;
		}

		
		
	}

	@OnOpen
	public void onOpen(Session session) throws IOException {
		MessageSender messageSender = new MessageSender(session);
		
		Account account = whiteboard.createAndAddAccount(messageSender);
		
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}
