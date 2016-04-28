package persist;

import java.util.List;
import model.AccountDO;
import model.WhiteboardDO;
import model.WhiteboardNameDO;

public interface IDatabase {
	public Integer insertAccount(final String email,final String password, final String username );
	public Integer removeAccount(final String email);
	public WhiteboardDO getWhiteboard(String whiteboardName);
	public WhiteboardDO clearWhiteboard(String whiteboardName);
	public Integer insertWhiteboard(final String whiteboardName, final AccountDO account);
	public Integer insertShape(final String shape, final String whiteboardName);
	public AccountDO getAccountbyEmail(final String email);
}
