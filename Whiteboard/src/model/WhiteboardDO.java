package model;

import java.util.ArrayList;
import java.util.List;

public class WhiteboardDO {
	private String wbName;
	private int wbKey;
	private List<ShapeDO> shapeList= new ArrayList<ShapeDO>();
	private List<AccountDO> accountList =  new ArrayList<AccountDO>();
	
	
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

	public WhiteboardDO() {
		
	}

	public List<ShapeDO> getShapeList() {
		return shapeList;
	}

	public void setShapeList(List<ShapeDO> shapeList) {
		this.shapeList = shapeList;
	}

	public List<AccountDO> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountDO> accountList) {
		this.accountList = accountList;
	}
}
