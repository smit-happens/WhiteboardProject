package QueryTesting;

import java.util.List;
import java.util.Scanner;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
public class InsertAccountQuery {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.print("Enter the email: ");
		String email = keyboard.nextLine();
		
		System.out.print("Enter the password: ");
		String password = keyboard.nextLine();
		
		System.out.print("Enter the username: ");
		String username = keyboard.nextLine();
		
		Integer accountKey= db.insertAccount(email, password, username);

		// check if the insertion succeeded
		if (accountKey > 0)
		{
			System.out.println("New account (Key: " + accountKey + ") successfully added to accounts table");
		}
		else
		{
			System.out.println("Failed to insert new account (Key: " + accountKey + ") into accounts table");			
		}
	}

}
