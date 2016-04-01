package com.pretech.test.websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Whiteboard {

	private static List<Account> accounts = new ArrayList<>(); 

	public Account createAndAddAccount(MessageSender messageSender) throws IOException {
		Account acct = new Account(this, messageSender);

		// Add the new account to the list of accounts on the whiteboard.
		accounts.add(acct);

		//		broadcastMessage(MessageCommand.NewUser, acct.getName());
		broadcastMessage(MessageCommand.NumberUsers, String.valueOf(accounts.size()));

		return acct;

	}
	public void removeAccount(Account a) throws IOException {
		// remove the specified account from the list
		int count=0;
		for(Account account: accounts){
			if(a.getName().equals(account.getName())){
				accounts.remove(count);
			}
			count++;
		}
		// Broadcast that one account is removed
		//			broadcastMessage(MessageCommand.DeleteUser, a.getName());
		broadcastMessage(MessageCommand.NumberUsers, String.valueOf(accounts.size()));
	}

	public void removeAccountBySessionId(String id) throws IOException {
		// remove the specified account from the list
		int count=0;
		for(int i=0; i< accounts.size(); i++){
			String acctId = accounts.get(i).getMessageSender().getSessionId();
			if(id.equals(acctId)){
				accounts.remove(count);
			}
			count++;
		}
		// Broadcast that one account is removed
		//		broadcastMessage(MessageCommand.DeleteUser, a.getName());
		broadcastMessage(MessageCommand.NumberUsers, String.valueOf(accounts.size()));
	}

	public void broadcastMessage(MessageCommand command, String content) throws IOException {
		//for (Account acct : accounts) {
		for(int i=0; i< accounts.size(); i++){
			accounts.get(i).sendSingleAccountMessage(command, content);
		}
	}

	public int getNumberOfAccounts(){
		return accounts.size();
	}


}
