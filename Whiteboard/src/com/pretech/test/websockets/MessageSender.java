package com.pretech.test.websockets;

import java.io.IOException;

import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

public class MessageSender {
	private Session session;
	
    public MessageSender(Session session) {
        this.session = session;
    }
	public void sendMessage(Message message) throws IOException{
		Basic basic= session.getBasicRemote();
		basic.sendText(message.getString());
	}
	
	public String getSessionId(){
		return this.session.getId();
	}
}
