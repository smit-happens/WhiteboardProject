package model;

public class AccountDO {
	private String email;
	private String password;
	private String username;
	private int accountKey;
	
	public int getAccountKey() {
		return accountKey;
	}
	public void setAccountKey(int accountKey) {
		this.accountKey = accountKey;
	}
	public AccountDO() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
