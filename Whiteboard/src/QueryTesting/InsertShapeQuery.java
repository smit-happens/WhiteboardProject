package QueryTesting;

import java.util.List;
import java.util.Scanner;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
public class InsertShapeQuery {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.print("Enter the shape: ");
		String shape = keyboard.nextLine();
		
		System.out.print("Enter the Whiteboard Name: ");
		String whiteboardName = keyboard.nextLine();
		
		Integer shapeKey= db.insertShape(shape, whiteboardName);

		// check if the insertion succeeded
		if (shapeKey > 0)
		{
			System.out.println("New shape (Key: " + shapeKey + ") successfully added to shapes table");
		}
		else
		{
			System.out.println("Failed to insert new shape (Key: " + shapeKey + ") into shapes table");			
		}
	}

}
