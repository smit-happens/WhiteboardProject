package QueryTesting;

import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class TestingOfAllSQLMethods {
	public static void main(String[] args) throws Exception {
		
		//NEED TO CHANGE THIS
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		
		
		// Testing InsertAccount
		// Testing getAccountbyemail
		
		
		// Testing InsertWhiteboard
		// Testing getwhiteboard
		
		// insertShape
		// Testing getwhiteboard: use get shapelist and loop through to verify inserted shapes
		
		
		// insertShape - now have two shapes
		// clearwhiteboard- no shapes now
		// Testing getwhiteboard: use get shapelist and loop through to verify no shapes
		
		//remove account
		// Testing getAccountbyemail
		
		
		
		
		
		// Testing Clearing Whitebaord
		String whiteboardName = "Cara's board";
		WhiteboardDO whiteboardDO= db.clearWhiteboard(whiteboardName);
		
		System.out.println("ShapeList Size: "+ whiteboardDO.getShapeList().size());
		// Testing getting accounts
		
		// Testing 
		
		//
		
		//
		
	}
}
