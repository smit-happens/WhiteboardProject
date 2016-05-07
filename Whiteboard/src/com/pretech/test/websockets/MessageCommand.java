package com.pretech.test.websockets;

public enum MessageCommand {
	
	Update, // Shape
	Login, // Name
	Logout, // Token
	CreateAccount, 
	LoginSuccessful,
	DeleteAccount,
	NumberUsers,
	Clear, 
	InvalidPassword, 
	InvalidEmailAccount,
	AccountExists,
	AccountCreated
}
