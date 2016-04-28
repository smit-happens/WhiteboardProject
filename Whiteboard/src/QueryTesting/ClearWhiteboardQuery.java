package QueryTesting;

import java.util.Scanner;

import model.WhiteboardDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class ClearWhiteboardQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.print("Enter the whiteboard name: ");
		String whiteboardName = keyboard.nextLine();
		
		WhiteboardDO whiteboardDO= db.clearWhiteboard(whiteboardName);
		
		System.out.println("ShapeList Size: "+ whiteboardDO.getShapeList().size());
	}
}
