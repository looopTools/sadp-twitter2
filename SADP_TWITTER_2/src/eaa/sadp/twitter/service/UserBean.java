package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.User;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class UserBean implements Serializable {

	private String name, password;
	private User user, otherUser;
	@Inject
	private Service service;
	
	public UserBean(){
		setName("");
		setPassword("");
		user = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		User tempUser = service.verifyUser(new User(name, password, false));
		if (tempUser != null){
			setUser(tempUser);
			return "success";
		}
		return "failure";
	}
	
	public String register(){
		if(service.createUser(name, password)){
			return "index";
		}else{
			return "error";
		}
	}
	
	public Map<String, User> getUsers(){
		return service.getUsers();
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public String logout(){
		user = null;
		name = "";
		password = "";
		return "login";
	}
	
	public String showUser(User user){
		this.setOtherUser(user);
		return "user";
	}

	public User getOtherUser() {
		return otherUser;
	}

	public void setOtherUser(User otherUser) {
		this.otherUser = otherUser;
	}
	
	public String following(){
		Set<User> userFollowingList = user.getFollowing();
		return userFollowingList.contains(otherUser) ? "Unfollow" : "Follow";
	}
	
	public String reverseFollowing(){
		if (user.getFollowing().contains(otherUser)){
			user.removeFollowing(otherUser);
		} else {
			user.addFollowing(otherUser);
		}
		return "followChange";
	}
}
