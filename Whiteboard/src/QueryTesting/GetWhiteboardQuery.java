package QueryTesting;

import java.util.List;
import java.util.Scanner;

import model.AccountDO;
import model.ShapeDO;
import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class GetWhiteboardQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		
		
		System.out.print("Enter the whiteboard name: ");
		String whiteboardName = keyboard.nextLine();
		
		WhiteboardDO whiteboardDO = db.getWhiteboard(whiteboardName);
		System.out.print("Whiteboard name: " + whiteboardName);
		System.out.print("Whiteboard Key: " + whiteboardDO.getWbKey());
		
		List<ShapeDO> shapeList =whiteboardDO.getShapeList();
		System.out.print("Shapes: ");
		for(int i=0; i< shapeList.size(); i++){
			System.out.print("Shape Key: " + shapeList.get(i).getShapeKey());
			System.out.print("Shape String: " + shapeList.get(i).getShapeString());
		}
		
		
		List<AccountDO> accountList = whiteboardDO.getAccountList();
		System.out.print("Accounts: ");
		for(int i=0; i< accountList.size(); i++){
			System.out.print("Account Key " + accountList.get(i).getAccountKey());
			System.out.print("Email: " + accountList.get(i).getEmail());
			System.out.print("Password: " + accountList.get(i).getPassword());
			System.out.print("Username: " + accountList.get(i).getUsername());
		}
		

	}
}
