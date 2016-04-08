package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Whiteboard;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	public Account insertAccount(final String email,final String password, final String username ) {
		return null;
	}	

	public Account removeAccount(final Account account) {
		return null;
	}	
	
	public void login(final String email,final String password, final String username ) {
		
	}	
	
	public Account insertAccount(final String email,final String password) {
		return null;
	}	
	
	public List<Whiteboard> ListWhiteboards(final Account account) {
		return null;
	}	
	
	public void shareWhiteboard(final Account account1, final Account account2, final String whiteboardName ) {
		
	}
	
	public boolean isVaildAccount(final Account account) {
		return false;
	}	
	
	public Whiteboard getWhiteboard(Whiteboard Whiteboard, String whiteboardName) {
		return null;
	}
	
	
	// transaction that inserts new Whiteboard into the table
	public Whiteboard insertWhiteboard(final String whiteboardName, final Account account) {
		return null;
	}
	
	
	// transaction that inserts a new shape into the data with the corresponding whiteboard
	public String insertShape(final String shape, final String whiteboardName)  {
		return null;
	}
	
	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you specify the location of your Derby SQL database
	// TODO: You will need to change this location to the same path as your workspace for this example
	// TODO: Change it here and in SQLDemo under CS320_Lab06->edu.ycp.cs320.sqldemo	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/CS320/CS320_Library_Example/CS320_Lab06/library.db;create=true");		
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// pass in more for whiteboard??
	private void loadWhiteboard(Whiteboard whiteboard, String shapes) throws SQLException {
		
	}
	
	// pass in more for Account?? should password be here if hashed??
	private void loadAccount(String email, String password, String username) throws SQLException {
		
	}
	
	//  creates all tables
	public void createTables() {
		
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
}
