package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AccountDO;
import model.ShapeDO;
import model.WhiteboardDO;
import model.WhiteboardNameDO;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	private static final int MAX_ATTEMPTS = 10;

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	public Integer insertAccount(final String email,final String password, final String username ) {
		return executeTransaction(new Transaction<Integer>() {

			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // insert new info into accounts table

				ResultSet resultSet1 = null; // accountKey


				try {
					stmt1 = conn.prepareStatement(
							"insert into accounts (email, password, username) " +
									"  values(?, ?,?) ",
									Statement.RETURN_GENERATED_KEYS);
					stmt1.setString(1, email);
					stmt1.setString(2, password);
					stmt1.setString(3, username);

					// execute the query, get the result
					stmt1.executeUpdate();
					resultSet1 = stmt1.getGeneratedKeys();

					resultSet1.next();
					Integer accountKey = resultSet1.getInt(1);
					return accountKey;

				}

				finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);				
				}

			}
		});
	}

	public Integer removeAccount(final String email) { 
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // get accountKey using email passed in
				PreparedStatement stmt2 = null;	// delete accountKey from junction table (wbAccounts)					
				PreparedStatement stmt3 = null; // delete accountKey from accounts table

				ResultSet resultSet1    = null;

				int accountKey= 0;

				try {
					// get accountKey
					stmt1 = conn.prepareStatement(
							"select accountKey from accounts " +
									"  where email = ? "
							);

					stmt1.setString(1, email);
					resultSet1 = stmt1.executeQuery();	
					
					while(resultSet1.next()){
						accountKey= resultSet1.getInt(1);
					}

					// first delete entries in wbAccounts junction table
					// can't delete entries in accounts table while they have foreign keys in junction table
					stmt2 = conn.prepareStatement(
							"delete from wbAccounts " +
									"  where accountKey = ? "
							);

					// delete the Book entries from the DB for this title
					stmt2.setInt(1, accountKey);
					stmt2.executeUpdate();

					System.out.println("Deleted junction table entry from DB");									

					// now delete entries in Books table for this title
					stmt3 = conn.prepareStatement(
							"delete from accounts " +
									"  where accountKey = ? "
							);

					// delete the Book entries from the DB for this title
					stmt3.setInt(1, accountKey);
					stmt3.executeUpdate();

					System.out.println("Deleted entry from account from DB");
					
					return accountKey;
					
				} finally {
					DBUtil.closeQuietly(resultSet1);

					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);		
					DBUtil.closeQuietly(stmt3);
				}
			}
		});
	}	

	public WhiteboardDO getWhiteboard(String whiteboardName) {

		return executeTransaction(new Transaction<WhiteboardDO>() {
			@Override
			public WhiteboardDO execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // get wb key of whiteboard passed in 
				PreparedStatement stmt2 = null; // join wbAccounts with Accounts; resultset2 to fill in accounts list(all accounts assocaited with whiteboard)
				PreparedStatement stmt3 = null; // get all shapes associated with the whiteboard passed in; resultset3 to fill shapes list

				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
				ResultSet resultSet3 = null;
				Integer wbKey= null;
				List<ShapeDO> shapeList = new ArrayList<ShapeDO>();
				WhiteboardDO whiteboardDO= new WhiteboardDO();
				List<AccountDO> accountList =  new ArrayList<AccountDO>();

				try {
					stmt1 = conn.prepareStatement(
							"select wbKey from wbNames" +
									"  where wbName = ?  "
							);
					stmt1.setString(1, whiteboardName);

					// execute the query, get the result
					resultSet1 = stmt1.executeQuery(); // wbKey

					// if whiteboardName was found then get wbKey					
					if (resultSet1.next())
					{
						wbKey = resultSet1.getInt(1);
						System.out.println("whiteboardName " + whiteboardName + " found with key: " + wbKey);						
					}
					else
					{
						System.out.println("whiteboardName <" + whiteboardName + "> not found");
						throw new PersistenceException("whiteboardName <" + whiteboardName + "> not found");
					}

					stmt2 = conn.prepareStatement(
							"select accounts.accountKey, accounts.email, accounts.password, accounts.username from accounts, wbAccounts" +
									" where wbAccounts.wbKey= ? and "
									+ " wbAccounts.accountKey = accounts.accountKey"
							);
					stmt2.setInt(1, wbKey);
					resultSet2 = stmt2.executeQuery();
					System.out.println("here with no error");
					while (resultSet2.next()) {
						AccountDO accountDO = new AccountDO();
						accountDO.setAccountKey(resultSet2.getInt(1));
						accountDO.setEmail(resultSet2.getString(2));
						accountDO.setPassword(resultSet2.getString(3));
						accountDO.setUsername(resultSet2.getString(4));
						accountList.add(accountDO);
					}

					stmt3 = conn.prepareStatement(
							"select shapeKey, shape from shapes" +
									" where wbKey = ?"
							);
					stmt3.setInt(1, wbKey);

					resultSet3 = stmt3.executeQuery(); // shapeKey and shape 

					// if shapes are in whiteboard save them all 				
					while (resultSet3.next()) {
						ShapeDO shapeDO = new ShapeDO();
						shapeDO.setShapeKey(resultSet3.getInt(1));
						shapeDO.setShapeString(resultSet3.getString(2));
						shapeList.add(shapeDO);
					}

					whiteboardDO.setShapeList(shapeList);
					whiteboardDO.setAccountList(accountList);
					whiteboardDO.setWbKey(wbKey);
					whiteboardDO.setWbName(whiteboardName);
					return whiteboardDO;
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

				// for saving accountKey
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
						System.out.println("account " + (account.getEmail()) + " found with key: " + accountKey);						
					}
					else
					{
						System.out.println("account <" + account.getEmail() + " > not found");
						throw new PersistenceException("account <" + (account.getEmail()) + "> not found");
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


					// if whiteboardName was found then save wbKey					
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
		Connection conn = DriverManager.getConnection("jdbc:derby:/Users/carasperbeck/Documents/lib.db;create=true");	  // for cara
		// Connection conn = DriverManager.getConnection("jdbc:derby:/Users/carasperbeck/Documents/lib.db;create=true");  // for smitty
		// Connection conn = DriverManager.getConnection("jdbc:derby:/Users/carasperbeck/Documents/lib.db;create=true");  // for aaron

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
							"create table wbAccounts (" +
									"	wbKey integer constraint wbKey references wbNames, " +
									"   accountKey integer constraint accountKey references accounts" +
									")"
							);
					stmt3.executeUpdate();

					stmt4 = conn.prepareStatement(
							"create table shapes (" +
									"	shapeKey integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	wbKey integer references wbNames, " +
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
				PreparedStatement insertShape = null;
				PreparedStatement insertWhiteboard = null;
				PreparedStatement insertAccount = null;
				PreparedStatement selectWhiteboards= null;
				PreparedStatement selectAccounts= null;
				PreparedStatement selectShapes = null;
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;

				try {
					whiteboardList = InitialData.getWhiteboard();
					accountList = InitialData.getAccounts();
					shapeList = InitialData.getShapes();

				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				try {

					// insert records into wbNames table
					insertWhiteboard = conn.prepareStatement("insert into wbNames (wbName) values (?)");
					insertWhiteboard.setString(1, whiteboardList.get(0).getWbName());
					insertWhiteboard.executeUpdate();
					insertWhiteboard.setString(1, whiteboardList.get(1).getWbName());
					insertWhiteboard.executeUpdate();
					insertWhiteboard.setString(1, whiteboardList.get(2).getWbName());
					insertWhiteboard.executeUpdate();
					System.out.println("created wbNames table");

					// get the primary keys from the records just inserted into wbNames for use later in wbAccounts join table
					selectWhiteboards = conn.prepareStatement("select wbKey from wbNames");
					selectWhiteboards.executeQuery();

					Integer autowbKey1=null;
					Integer autowbKey2=null;
					Integer autowbKey3=null;
					resultSet1 = selectWhiteboards.getResultSet();
					System.out.println(resultSet1.getFetchSize());
					resultSet1.next();
					autowbKey1 = resultSet1.getInt(1);
					System.out.println(autowbKey1);
					resultSet1.next();
					autowbKey2 = resultSet1.getInt(1);
					System.out.println(autowbKey2);
					resultSet1.next();
					autowbKey3 = resultSet1.getInt(1);
					System.out.println(autowbKey3);

					// insert records into shape table
					insertShape = conn.prepareStatement("insert into shapes (wbKey, shape) values (?, ?)");

					insertShape.setInt(1, autowbKey1 );
					insertShape.setString(2, ((ShapeDO) shapeList.get(0)).getShapeString());
					insertShape.addBatch();
					insertShape.setInt(1, autowbKey2 );
					insertShape.setString(2, ((ShapeDO) shapeList.get(1)).getShapeString());
					insertShape.addBatch();
					insertShape.setInt(1, autowbKey3 );
					insertShape.setString(2, ((ShapeDO) shapeList.get(2)).getShapeString());
					insertShape.addBatch();

					insertShape.executeBatch();
					System.out.println("created Shape table");


					// insert records into accounts table
					insertAccount = conn.prepareStatement("insert into accounts (email, password, username) values (?, ?, ?)");
					for (AccountDO account : accountList) {
						insertAccount.setString(1, account.getEmail());
						insertAccount.setString(2, account.getPassword());
						insertAccount.setString(3, account.getUsername());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();
					System.out.println("created Accounts table");

					// get the primary keys from the records just inserted into accounts for use later in wbAccounts join table
					selectAccounts = conn.prepareStatement("select accountKey from accounts");
					selectAccounts.executeQuery();

					resultSet2 = selectAccounts.getResultSet();
					Integer autoAccountKey1=null;
					Integer autoAccountKey2=null;
					Integer autoAccountKey3=null;
					resultSet2.next();
					autoAccountKey1 = resultSet2.getInt(1);
					resultSet2.next();
					autoAccountKey2 = resultSet2.getInt(1);
					resultSet2.next();
					autoAccountKey3 = resultSet2.getInt(1);


					//create a prepared statement that does an insert into our wbAccounts join table
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
					DBUtil.closeQuietly(selectWhiteboards);
					DBUtil.closeQuietly(selectAccounts);
					DBUtil.closeQuietly(selectShapes);
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

	@Override
	public WhiteboardDO clearWhiteboard(String whiteboardName) {
		return executeTransaction(new Transaction<WhiteboardDO>() {

			@Override
			public WhiteboardDO execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // get wbKey from wbName table using whiteboardName
				PreparedStatement stmt2 = null; // using wbKey from above, delete all shapes with that whiteboard key in wbShapes table
				PreparedStatement stmt3 = null; // get shapeList
				PreparedStatement stmt4 = null; // join wbAccounts with Accounts; resultset2 to fill in accounts list(all accounts assocaited with whiteboard)

				ResultSet resultSet1 = null; // accountKey
				ResultSet resultSet3 = null; 
				ResultSet resultSet4 = null; 
				List<ShapeDO> shapeList = new ArrayList<ShapeDO>();
				List<AccountDO> accountList = new ArrayList<AccountDO>();

				WhiteboardDO wbDO = new WhiteboardDO();
				int wbKey = 0;


				try {
					stmt1 = conn.prepareStatement(
							"select wbKey from wbNames" +
									"  where wbName = ?  "
							);
					stmt1.setString(1, whiteboardName);

					// execute the query, get the result
					resultSet1 = stmt1.executeQuery(); // wbKey
					while(resultSet1.next()){
						wbKey = resultSet1.getInt(1);
					}

					stmt2 = conn.prepareStatement(
							"delete from shapes" +
									"  where wbKey = ?  "
							);
					stmt2.setInt(1, wbKey);

					stmt2.executeUpdate();

					stmt3 = conn.prepareStatement(
							"select * from shapes" +
									" where wbKey = ? "
							);
					stmt3.setInt(1, wbKey);

					stmt3.executeQuery(); 
					resultSet3 = stmt3.getResultSet(); // shapeKey and shape 
					
					while (resultSet3.next()) { // should be empty now
						ShapeDO shapeDO = new ShapeDO();
						loadShape(shapeDO, resultSet3, 1);
						shapeList.add(shapeDO);
					}

					stmt4 = conn.prepareStatement(
							"select * from accounts,wbAccounts" +
									" where wbAccounts.wbKey = ? and "
									+ "wbAccounts.accountKey = accounts.accountKey"
							);
					stmt4.setInt(1, wbKey);
					resultSet4 = stmt4.executeQuery();

					while (resultSet4.next()) {
						AccountDO accountDO = new AccountDO();
						loadAccount(accountDO, resultSet4, 1);
						accountList.add(accountDO);
					}

					wbDO.setWbKey(wbKey);
					wbDO.setShapeList(shapeList);
					wbDO.setAccountList(accountList);
					wbDO.setWbName(whiteboardName);
					return wbDO;
				}


				finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(resultSet4);
					DBUtil.closeQuietly(stmt1);	
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
				}

			}
		});
	}

	@Override
	public AccountDO getAccountbyEmail(String email) {
		return executeTransaction(new Transaction<AccountDO>() {

			@Override
			public AccountDO execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null; // return everything from accounts using the email passed in
				AccountDO accountDO = new AccountDO();
				ResultSet resultSet1 = null; // accountKey

				try {
					stmt1 = conn.prepareStatement(
							"select * from accounts" +
									" where email = ? "
							);
					stmt1.setString(1, email);
					resultSet1 = stmt1.executeQuery();

					if(resultSet1.next()) {
						loadAccount(accountDO, resultSet1, 1);
					}
					return accountDO;
				}

				finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);				
				}

			}
		});
	}
}