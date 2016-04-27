package persist;

import java.util.List;
import model.AccountDO;
import model.WhiteboardDO;
import model.WhiteboardNameDO;

public interface IDatabase {
	public Integer insertAccount(final String email,final String password, final String username );
	public AccountDO removeAccount(final AccountDO account);
	//public WhiteboardDO login(final String email,final String password, final String username);
	//public List<WhiteboardNameDO> ListWhiteboards(final AccountDO account);	
	public Boolean isVaildAccount(final AccountDO account);	
	public WhiteboardDO getWhiteboard(String whiteboardName);
	public WhiteboardDO clearWhiteboard(String whiteboardName);
	public Integer insertWhiteboard(final String whiteboardName, final AccountDO account);
	public Integer insertShape(final String shape, final String whiteboardName);
}
