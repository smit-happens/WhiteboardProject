package com.pretech.test.websockets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint.Basic;

public class MockBasic implements Basic {

	@Override
	public void flushBatch() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getBatchingAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendPing(ByteBuffer arg0) throws IOException, IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendPong(ByteBuffer arg0) throws IOException, IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBatchingAllowed(boolean arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public OutputStream getSendStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Writer getSendWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendBinary(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBinary(ByteBuffer arg0, boolean arg1) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendObject(Object arg0) throws IOException, EncodeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendText(String arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendText(String arg0, boolean arg1) throws IOException {
		// TODO Auto-generated method stub

	}

}
