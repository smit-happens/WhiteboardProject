package com.pretech.test.websockets;

public abstract class Shape {
	double girth; 
	int color;
	Account accountID;
	
	public Account getAccountID() {
		return accountID;
	}
	
	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}
	
	public double getGirth() {
		return girth;
	}
	
	public void setGirth(double girth) {
		this.girth = girth;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
}
