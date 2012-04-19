package eaa.sadp.twitter.model;

public class User {

	private String username, password;
	private boolean admin;
	
	public User(String username, String password, boolean admin){
		this.username = username;
		this.password = password;
		this.admin = admin;
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
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
