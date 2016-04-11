package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.AccountDO;
import model.ShapeDO;
import model.WhiteboardNameDO;

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
	
	public Integer insertAccount(final String email,final String password, final String username ) {
		return null;
	}	

	public AccountDO removeAccount(final AccountDO account) {
		return null;
	}	
	
	public void login(final String email,final String password, final String username ) {
		
	}	
	
	public AccountDO insertAccount(final String email,final String password) {
		return null;
	}	
	
	public List<WhiteboardNameDO> ListWhiteboards(final AccountDO account) {
		return null;
	}	
	
	public void shareWhiteboard(final AccountDO account1, final AccountDO account2, final String whiteboardName ) {
		
	}
	
	public boolean isVaildAccount(final AccountDO account) {
		return false;
	}	
	
	public WhiteboardNameDO getWhiteboard(String whiteboardName) {
		PreparedStatement stmt1 = null; // get wb key of whiteboard passed in 
		PreparedStatement stmt2 = null; // join wbAccounts with Accounts; resultset2 to fill in accounts list
		PreparedStatement stmt3 = null; // get all shapes associated with the whiteboard passed in; resultset3 to fill shapes list
		return null;
	}
	
	
	// transaction that inserts new Whiteboard into the table
	public Integer insertWhiteboard(final String whiteboardName, final AccountDO account) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // get account key
				PreparedStatement stmt2 = null; // insert new whiteboard name into WBnames table and autogenerate primary wbKey
				PreparedStatement stmt3 = null; // insert new row into wbAccounts table
				
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
				
				// for saving whiteboard ID
				Integer accountKey = -1;

				// try to retrieve whiteboard id (if it exists) 
				try {
					stmt1 = conn.prepareStatement(
							"select accountKey from accounts" +
							"  where username = ?  "
					);
					stmt1.setString(1, account.getUsername());
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if whiteboardName was found then save shape					
					if (resultSet1.next())
					{
						accountKey = resultSet1.getInt(1);
						System.out.println("account " + account + "found with key: " + accountKey);						
					}
					else
					{
						System.out.println("account <" + account + "> not found");
						throw new PersistenceException("account <" + account + "> not found");
					}
					stmt2 = conn.prepareStatement(
							"insert into wbNames (wbName) " +
							"  values(?) ",
							Statement.RETURN_GENERATED_KEYS);
					stmt2.setString(1, whiteboardName);
					stmt2.executeUpdate();
					
					resultSet2 = stmt2.getGeneratedKeys();
					Integer autoWBKey=null;
					if(resultSet2.next()){
						autoWBKey = resultSet2.getInt(1);
						
					}
					else{
						System.out.println("autoWBKey" + autoWBKey + "> not generated");
						throw new PersistenceException("autoWBKey" + autoWBKey + "> not generated");
					}
					
					stmt3 = conn.prepareStatement(
							"insert into wbAccounts (wbKey, accountKey) " +
							"  values(?, ?) ");
					stmt3.setInt(1, autoWBKey);
					stmt3.setInt(2, accountKey);
					stmt3.executeUpdate();
					
					return autoWBKey;

				}

					finally {
						DBUtil.closeQuietly(resultSet1);
						DBUtil.closeQuietly(stmt1);
						DBUtil.closeQuietly(resultSet2);
						DBUtil.closeQuietly(stmt2);	
						DBUtil.closeQuietly(stmt3);					
					}
			}
		});
	}
	
	@Override
	// transaction that inserts a new shape into the data with the corresponding whiteboard
	public Integer insertShape(final String shape, final String whiteboardName)  {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // get whiteboard id
				PreparedStatement stmt2 = null; // insert shape
				PreparedStatement stmt3 = null; // get id of shape inserted
				
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
				
				// for saving whiteboard ID
				Integer wbKey = -1;

				// try to retrieve whiteboard id (if it exists) 
				try {
					stmt1 = conn.prepareStatement(
							"select wbKey from wbNames" +
							"  where wbName = ?  "
					);
					stmt1.setString(1, whiteboardName);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if whiteboardName was found then save shape					
					if (resultSet1.next())
					{
						wbKey = resultSet1.getInt(1);
						System.out.println("whiteboardName " + whiteboardName + "found with key: " + wbKey);						
					}
					else
					{
						System.out.println("whiteboardName <" + whiteboardName + "> not found");
						throw new PersistenceException("whiteboardName <" + whiteboardName + "> not found");
					}
					stmt2 = conn.prepareStatement(
							"insert into shapes (wbKey, shape) " +
							"  values(?, ?) ",
							Statement.RETURN_GENERATED_KEYS	);
					stmt2.setInt(1, wbKey);
					stmt2.setString(2, shape);
					stmt2.executeUpdate();
					
					resultSet2 = stmt2.getGeneratedKeys();
					Integer autoShapeKey=null;
					if(resultSet2.next()){
						autoShapeKey = resultSet2.getInt(1);
						return autoShapeKey;
					}
					else{
						System.out.println("autoShapeKey" + autoShapeKey + "> not generated");
						throw new PersistenceException("autoShapeKey" + autoShapeKey + "> not generated");
					}
						
					
				}
					
					finally {
						DBUtil.closeQuietly(resultSet1);
						DBUtil.closeQuietly(stmt1);
						DBUtil.closeQuietly(resultSet2);
						DBUtil.closeQuietly(stmt2);					
					}
			}
		});
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
	
	private void loadWhiteboard(WhiteboardNameDO whiteboard, ResultSet resultSet, int index) throws SQLException {
		whiteboard.setWbKey(resultSet.getInt(index++));
		whiteboard.setWbName(resultSet.getString(index++));
	}
	
	private void loadAccount(AccountDO account, ResultSet resultSet, int index) throws SQLException {
		account.setAccountKey(resultSet.getInt(index++));
		account.setEmail(resultSet.getString(index++));
		account.setPassword(resultSet.getString(index++));
		account.setUsername(resultSet.getString(index++));
	}
	private void loadShape(ShapeDO shape, ResultSet resultSet, int index) throws SQLException {
		shape.setShapeKey(resultSet.getInt(index++));
		shape.setShapeString(resultSet.getString(index++));
	}
	
	//  creates all tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				
				try {
					stmt1 = conn.prepareStatement(
						"create table accounts (" +
						"	accountKey integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	email varchar(40)," +
						"	password varchar(40)," +
						"   username varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table wbNames (" +
							"	wbKey integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	wbName varchar(50)" +
							")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table wbAcounts (" +
							"	wbKey integer constraint wbKey references wbNames, " +
							"   accountKey integer constraint accountKey references accounts" +
							")"
					);
					stmt3.executeUpdate();
					
					stmt4 = conn.prepareStatement(
							"create table shapes (" +
							"	shapeKey integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	wbKey integer constraint wbKey references wbNames, " +
							"	shape varchar(255)" +
							")"
					);
					stmt4.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<WhiteboardNameDO> whiteboardList;
				List<AccountDO> accountList;
				List<ShapeDO> shapeList;
				
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
				
				try {
					whiteboardList = InitialData.getWhiteboard();
					accountList = InitialData.getAccounts();
					shapeList = InitialData.getShapes();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				
				PreparedStatement insertShape = null;
				PreparedStatement insertWhiteboard = null;
				PreparedStatement insertAccount = null;
				
				try {
					insertShape = conn.prepareStatement("insert into shapes (shape) values (?)");
					for (ShapeDO shape : shapeList) {
						insertShape.setString(1, shape.getShapeString());
						insertShape.addBatch();
					}
					insertShape.executeBatch();
					
					insertWhiteboard = conn.prepareStatement("insert into wbNames (wbName) values (?)",  Statement.RETURN_GENERATED_KEYS);
					for (WhiteboardNameDO whiteboard : whiteboardList) {
						insertWhiteboard.setString(1, whiteboard.getWbName());
						insertWhiteboard.addBatch();
					}
					insertWhiteboard.executeBatch();
					resultSet1 = insertWhiteboard.getGeneratedKeys();
					Integer autowbKey1=null;
					Integer autowbKey2=null;
					Integer autowbKey3=null;
					if(resultSet1.next()){
						autowbKey1 = resultSet2.getInt(1);
						autowbKey2 = resultSet2.getInt(2);
						autowbKey3 = resultSet2.getInt(3);
					}
					else{
						System.out.println("autoShapeKey not generated");
						throw new PersistenceException("autoShapeKey not generated");
					}
					
					insertAccount = conn.prepareStatement("insert into Accounts (email, password, username) values (?, ?, ?)",  Statement.RETURN_GENERATED_KEYS);
					for (AccountDO account : accountList) {
						insertShape.setString(1, account.getEmail());
						insertShape.setString(2, account.getPassword());
						insertShape.setString(3, account.getUsername());
						insertShape.addBatch();
					}
					insertAccount.executeBatch();
					resultSet2 = insertAccount.getGeneratedKeys();
					Integer autoAccountKey1=null;
					Integer autoAccountKey2=null;
					Integer autoAccountKey3=null;
					if(resultSet2.next()){
						autoAccountKey1 = resultSet2.getInt(1);
						autoAccountKey2 = resultSet2.getInt(2);
						autoAccountKey3 = resultSet2.getInt(3);
					}
					else{
						System.out.println("autoShapeKey not generated");
						throw new PersistenceException("autoShapeKey not generated");
					}
					//create a prepared statement that does an insert into our join table
					stmt1 = conn.prepareStatement(
							"insert into wbAccounts (wbKey, accountKey) " +
							"  values(?, ?) ");
					stmt1.setInt(1, autowbKey1);
					stmt1.setInt(2, autoAccountKey1);
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"insert into wbAccounts (wbKey, accountKey) " +
							"  values(?, ?) ");
					stmt2.setInt(1, autowbKey2);
					stmt2.setInt(2, autoAccountKey2);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"insert into wbAccounts (wbKey, accountKey) " +
							"  values(?, ?) ");
					stmt3.setInt(1, autowbKey3);
					stmt3.setInt(2, autoAccountKey3);
					stmt3.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertShape);
					DBUtil.closeQuietly(insertWhiteboard);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(resultSet2);
				}
			}
		});
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
