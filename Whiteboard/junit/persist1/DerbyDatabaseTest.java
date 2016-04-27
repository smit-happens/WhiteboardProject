package persist1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persist.IDatabase;
import persist.DatabaseProvider;
import persist.DerbyDatabase;

public class DerbyDatabaseTest {

	private IDatabase db = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertWhiteboardIntoWBNamesandAccountsTable() {
		
	}
	
	@Test
	public void testInsertAccountIntoAccountsTable() {
		System.out.println("\n*** Testing InsertAccountIntoAccountsTable ***");

		String email     = "csperbeck6@gmail.com";
		String password  = "sheep";
		String username  = "csperbeck6";
				
		// insert new book (and possibly new author) into DB
		Integer accountKey = db.insertAccount(email, password, username);
		// check the return value - should be a book_id > 0
				if (accountKey > 0)
				{
					// try to retrieve the book and author from the DB
					// get the list of (Author, Book) pairs from DB
					authorBookList = db.findAuthorAndBookByAuthorLastName(lastName);
					
					if (AccountList.isEmpty()) {
						System.out.println("No accounts found for author <" + lastName + ">");
						fail("Failed to insert new book <" + title + "> into Library DB");
					}
					// otherwise, the test was successful.  Now remove the book just inserted to return the DB
					// to it's original state, except for using an author_id and a book_id
					else {
						System.out.println("New book (ID: " + book_id + ") successfully added to Books table: <" + title + ">");
						
						// now delete Book (and its Author) from DB
						// leaving the DB in its previous state - except that an author_id, and a book_id have been used
						List<Author> authors = db.removeBookByTitle(title);				
					}
				}
				else
				{
					System.out.println("Failed to insert new account (Key: " + accountKey + ") into accountKey table: <" + email + ">");
					fail("Failed to insert new account <" + email + "> into Library DB");
				}
		
	}
	
	@Test
	public void testInsertShapesIntoShapesTable() {
		
	}

}
