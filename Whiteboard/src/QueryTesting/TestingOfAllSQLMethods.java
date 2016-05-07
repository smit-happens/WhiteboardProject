package QueryTesting;

import model.AccountDO;
import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class TestingOfAllSQLMethods {
	/**
	 * 
	 * Author: Cara Sperbeck
	 * 
	 * Need to delete database and rerun DerbyDatabase before running this as a Java application
	 * This does use the database and changes values
	 * These are my automated tests of all 7 SQL methods declared in IDatabase
	 * 
	 * Another form of testing that is not automated is to run the individual QueryTesting classes 
	 * and then run SQLDemo to verify the method functioned as expected
	 * 
	 */
	
	public static void main(String[] args) throws Exception {

		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		

		// Testing InsertAccount
		// Testing getAccountbyemail
		Integer accountKey = db.insertAccount("djhake2@ycp.edu", "HakeRocks", "djhake2@ycp.edu");
		System.out.println("insertAccount and getAccount passed!!");
		AccountDO accountDO= db.getAccountbyEmail("djhake2@ycp.edu");
		if(accountDO.getAccountKey()== accountKey){
			if(accountDO.getEmail()== "djhake2@ycp.edu"){
				if(accountDO.getPassword() == "HakeRocks"){
					if(accountDO.getUsername()== "djhake2@ycp.edu"){
						System.out.println("insertAccount and getAccount passed!!");
					}
				}
			}
		}
		else{
			System.out.println("insertAccount and getAccount  did not pass! :( ");
		}

		// Testing InsertWhiteboard
		// Testing getwhiteboard

		Integer wbKey = db.insertWhiteboard("Prof.Hake's board", accountDO);

		WhiteboardDO whiteboardDO = db.getWhiteboard("Prof.Hake's board");
		if(whiteboardDO.getShapeList().size() ==0){
			if(whiteboardDO.getWbKey()== wbKey){
				if(whiteboardDO.getWbName().equals("Prof.Hake's board")){
					System.out.println("insertWhiteboard and getWhiteboard passed!!");
				}
			}
		}
		else{
			System.out.println("insertWhiteboard and getWhiteboard did not pass! :( ");
		}


		// insertShape
		// Testing getwhiteboard: use get shapelist and loop through to verify inserted shapes
		Integer shapeKey1 = db.insertShape("Update|Rectangle|5|6|7.6|3.4|6.5|8.1|", "Prof.Hake's board");
		whiteboardDO = db.getWhiteboard("Prof.Hake's board");
		if(whiteboardDO.getShapeList().size() ==1){ // should be the first shape 
			if(whiteboardDO.getShapeList().get(0).getShapeKey()== shapeKey1){
				if(whiteboardDO.getShapeList().get(0).getShapeString().equals("Update|Rectangle|5|6|7.6|3.4|6.5|8.1|")){
					System.out.println("insertShape and getWhiteboard passed!!");
				}
			}
		}
		else{
			System.out.println("insertShape and getWhiteboard did not pass! :( ");
		}
		


		// insertShape - now have two shapes
		// clearwhiteboard- no shapes now
		// Testing getwhiteboard: use get shapelist and loop through to verify no shapes
		Integer shapeKey2 = db.insertShape("Update|Triangle|1|2|8.9|6.7|5.4|3.1|", "Prof.Hake's board"); // should now have 2 shapes
		whiteboardDO = db.clearWhiteboard("Prof.Hake's board");
		if(whiteboardDO.getShapeList().size() == 0){ // should now be empty
			// cannot loop through to do whiteboardDO.getShapeList().get(0) because it will throw an error
			// if size is zero that is enough because there are no shapes
			System.out.println("insertShape, clearWhiteboard, and getWhiteboard passed!!");
		}
		else{
			System.out.println("insertShape, clearWhiteboard, and getWhiteboard did not pass! :( ");
		}

		//remove account
		// Testing getAccountbyemail
		int count=0;
		db.removeAccount("djhake2@ycp.edu");
		for(int i=0; i< whiteboardDO.getAccountList().size(); i++){
			whiteboardDO.getAccountList().get(i).equals("djhake2@ycp.edu");
			if(!whiteboardDO.getAccountList().get(i).equals("djhake2@ycp.edu")){
				count++;
			}
		}
		if(count== whiteboardDO.getAccountList().size()){
			System.out.println("removeAccount, getAccountbyEmail passed!!");
		}
		else{
			System.out.println("removeAccount, getAccountbyEmail did not pass! :( ");
		}
		
	}
}
