package eaa.sadp.twitter.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import eaa.sadp.twitter.model.User;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class Dao implements Serializable{
	
	private Map<String, User> users;
	
	public Dao(){
		// String is username and User is the user with that username
		users = new HashMap<String, User>();
		users.put("lars", new User("lars", "1212", true));
		users.put("malik", new User("malik", "test", true));
	}
	
	public Map<String, User> getUsers(){
		return new HashMap<String, User>(users);
	}
	
	public void addUser(User user){
		users.put(user.getUsername(), user);
	}
}