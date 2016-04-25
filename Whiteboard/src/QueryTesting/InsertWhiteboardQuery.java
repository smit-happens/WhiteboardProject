package QueryTesting;

import java.util.List;
import java.util.Scanner;

import model.AccountDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
public class InsertWhiteboardQuery {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.print("Enter the Whiteboard Name: ");
		String wbName = keyboard.nextLine();
		AccountDO account = new AccountDO();
		String email = "csperbec@ycp.edu";
		String password = "cat";
		String username = "Cara";
		account.setEmail(email);
		account.setPassword(password);
		account.setUsername(username);
		
		Integer wbKey= db.insertWhiteboard(wbName, account);

		// check if the insertion succeeded
		if (wbKey > 0)
		{
			System.out.println("New wb (Key: " + wbKey + ") successfully added to wbNames table");
		}
		else
		{
			System.out.println("Failed to insert new wb (Key: " + wbKey + ") into wbNames table");			
		}
	}

}
