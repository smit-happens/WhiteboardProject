package com.pretech.test.websockets;

public enum MessageCommand {
	
	Update, // Shape
	Login, // Name
	Logout, // Token
	Mode, // Manual or Live or Offline
	NewUser, 
	DeleteUser,
	NumberUsers,
	Redo,
	Undo, 
	Clear
}
