package persist;

import java.util.List;
import model.AccountDO;
import model.WhiteboardDO;
import model.WhiteboardNameDO;

public interface IDatabase {
	public Integer insertAccount(final String email,final String password, final String username );
	public AccountDO removeAccount(final AccountDO account);
	public void login(final String email,final String password, final String username );
	public List<WhiteboardNameDO> ListWhiteboards(final AccountDO account);	
	public void shareWhiteboard(final AccountDO account1, final AccountDO account2, final String whiteboardName );
	public boolean isVaildAccount(final AccountDO account);	
	public WhiteboardDO getWhiteboard(String whiteboardName);
	public Integer insertWhiteboard(final String whiteboardName, final AccountDO account);
	public Integer insertShape(final String shape, final String whiteboardName);
}
