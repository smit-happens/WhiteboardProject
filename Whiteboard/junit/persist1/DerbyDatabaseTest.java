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

		
	}
	
	@Test
	public void testInsertShapesIntoShapesTable() {
		
	}

}
