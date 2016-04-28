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

		System.out.print("AccountKey: " + accountDO.getAccountKey());
		System.out.print("Email: " + accountDO.getEmail());
		System.out.print("Password: " + accountDO.getPassword());
		System.out.print("Username: " + accountDO.getUsername());
	}
}
