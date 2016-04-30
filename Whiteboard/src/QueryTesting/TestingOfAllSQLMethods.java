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
