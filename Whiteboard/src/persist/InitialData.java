package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.AccountDO;
import model.WhiteboardNameDO;
import model.ShapeDO;

public class InitialData {
	List<WhiteboardNameDO> whiteboardList;
	List<ShapeDO> shapeList;
	List<AccountDO> accountList;
	
	public static List<WhiteboardNameDO> getWhiteboard() throws IOException {
		List<WhiteboardNameDO> whiteboardList = new ArrayList<WhiteboardNameDO>();
		WhiteboardNameDO whiteboardObject1= new WhiteboardNameDO();
		WhiteboardNameDO whiteboardObject2= new WhiteboardNameDO();
		WhiteboardNameDO whiteboardObject3= new WhiteboardNameDO();
		whiteboardObject1.setWbName("CS 320 board");
		whiteboardList.add(whiteboardObject1);
		whiteboardObject2.setWbName("Aaron's board");
		whiteboardList.add(whiteboardObject2);
		whiteboardObject3.setWbName("Smitty's board");
		whiteboardList.add(whiteboardObject3);
		System.out.println("whiteboard list created");
		return whiteboardList;
	}
	
	public static List<AccountDO> getAccounts() throws IOException {
		List<AccountDO> AccountList = new ArrayList<AccountDO>();
		AccountDO accountObject1 = new AccountDO();
		AccountDO accountObject2 = new AccountDO();
		AccountDO accountObject3 = new AccountDO();
		accountObject1.setEmail("csperbec@ycp.edu");
		accountObject1.setPassword("cat");
		accountObject1.setUsername("Cara");
		AccountList.add(accountObject1);
		accountObject2.setEmail("awalsh6@ycp.edu");
		accountObject2.setPassword("dog");
		accountObject2.setUsername("Aaron");
		AccountList.add(accountObject2);
		accountObject3.setEmail("asmit147@ycp.edu");
		accountObject3.setPassword("frog");
		accountObject3.setUsername("Smitty");
		AccountList.add(accountObject3);
		System.out.println("account list created");
		return AccountList;
	}
	
	public static List<ShapeDO> getShapes() throws IOException {
		List<ShapeDO> shapeList = new ArrayList<ShapeDO>();
		ShapeDO shapeObject1 = new ShapeDO();
		ShapeDO shapeObject2 = new ShapeDO();
		ShapeDO shapeObject3 = new ShapeDO();
		shapeObject1.setShapeString("Update|Circle|5.4|6|8|3.2|9.54|");
		shapeList.add(shapeObject1);
		shapeObject2.setShapeString("Update|Rectangle|5|6|7.6|3.4|6.5|8.1|");
		shapeList.add(shapeObject2);
		shapeObject3.setShapeString("Update|Triangle|1|2|8.9|6.7|5.4|3.1|");
		shapeList.add(shapeObject3);
		System.out.println("shape list created");
		return shapeList;
		
	}
}
