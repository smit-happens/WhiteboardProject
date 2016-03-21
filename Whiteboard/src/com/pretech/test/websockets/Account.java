package com.pretech.test.websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Whiteboard whiteboard;
    private long lastReceivedMessageId = 0; // do we keep this?
    private final MessageSender messageSender;
    private String password;
    private String name;
    private final List<Message> messages = new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public Account(Whiteboard whiteboard, MessageSender messageSender) {
        this.whiteboard = whiteboard;
        this.messageSender = messageSender;
    }

    public Whiteboard getWhiteboard() {
        return whiteboard;
    }

    public MessageSender getMessageSender() {
        return messageSender;
    }
  
    public void removeAccountFromWhiteboard() throws IOException {
        if (whiteboard != null) {
            whiteboard.removeAccount(this);
            whiteboard = null;
        }
    }

/*
    private long getLastReceivedMessageId() {
        return lastReceivedMessageId;
    }
    private void setLastReceivedMessageId(long value) {
        lastReceivedMessageId = value;
    }
*/


    public void sendSingleAccountMessage(MessageCommand command, String content) throws IOException {
        if (content == null || command == null)
            throw new NullPointerException();

        messageSender.sendMessage(new Message(command.toString() + "|" + content));
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
