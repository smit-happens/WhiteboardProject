package QueryTesting;

import java.util.Scanner;

import model.AccountDO;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class getAccountbyEmailQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		// get the DB instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();

		System.out.print("Enter the email: ");
		String email = keyboard.nextLine();
		
		AccountDO accountDO= db.getAccountbyEmail(email);

		System.out.println("AccountKey: " + accountDO.getAccountKey());
		System.out.println("Email: " + accountDO.getEmail());
		System.out.println("Password: " + accountDO.getPassword());
		System.out.println("Username: " + accountDO.getUsername());
	}
}
