package persist;

import java.util.List;
import model.Account;
import model.Whiteboard;

public interface IDatabase {
	public Account insertAccount(final String email,final String password, final String username );
	public Account removeAccount(final Account account);
	public void login(final String email,final String password, final String username );
	public Account insertAccount(final String email,final String password);
	public List<Whiteboard> ListWhiteboards(final Account account);	
	public void shareWhiteboard(final Account account1, final Account account2, final String whiteboardName );
	public boolean isVaildAccount(final Account account);	
	public Whiteboard getWhiteboard(Whiteboard Whiteboard, String whiteboardName);
	public Whiteboard insertWhiteboard(final String whiteboardName, final Account account);
	public String insertShape(final String shape, final String whiteboardName);
}
