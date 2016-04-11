package model;

public class WhiteboardDO {
	private String wbName;
	private int wbKey;
	private ShapeDO[] shapearr;
	private AccountDO[] accountarr;
	
	public String getWbName() {
		return wbName;
	}

	public void setWbName(String wbName) {
		this.wbName = wbName;
	}

	public int getWbKey() {
		return wbKey;
	}

	public void setWbKey(int wbKey) {
		this.wbKey = wbKey;
	}

	public ShapeDO[] getShapearr() {
		return shapearr;
	}

	public void setShapearr(ShapeDO[] shapearr) {
		this.shapearr = shapearr;
	}

	public AccountDO[] getAccountarr() {
		return accountarr;
	}

	public void setAccountarr(AccountDO[] accountarr) {
		this.accountarr = accountarr;
	}

	public WhiteboardDO() {
		
	}
}
