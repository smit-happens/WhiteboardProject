package com.pretech.test.websockets;

import java.io.IOException;

import javax.websocket.Session;

public class MessageSender {
	private Session session;
	
    public MessageSender(Session session) {
        this.session = session;
    }
	public void sendMessage(Message message) throws IOException{
		System.out.println("before message");
		session.getBasicRemote().sendText(message.getString());
		System.out.println("after message");
	}
}
