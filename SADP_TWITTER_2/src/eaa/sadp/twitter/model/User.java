package eaa.sadp.twitter.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private String username, password;
	private boolean admin;
	private Set<User> following;
	
	public User(String username, String password, boolean admin){
		this.username = username;
		this.password = password;
		this.admin = admin;
		setFollowing(new HashSet<User>());
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
	
	public void addFollowing(User user){
		if (user != this){
			following.add(user);
		}
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	public void removeFollowing(User otherUser) {
		following.remove(otherUser);
	}

}
