package com.pretech.test.websockets;

import java.io.IOException;

import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

public class MockMessageSender {
	private Session session;
	
    public MockMessageSender(Session session) {
        this.session = session; // MockWebsocketSession is passed in as parameter session in the unit test
    }
	public void sendMessage(Message message) throws IOException{
		Basic basic= session.getBasicRemote(); // MockWebsocketSession returns a MockBasic
		basic.sendText(message.getString()); // MockBasic sendText does nothing
	}
	
	public String getSessionId(){
		return this.session.getId();
	}
}
