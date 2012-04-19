package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.dao.Dao;
import eaa.sadp.twitter.model.User;

@Named
@ApplicationScoped
public class Service implements Serializable{

	@Inject
	private Dao dao;
	
	public boolean verifyUser(User user){
		Map<String, User> users = dao.getUsers();
		User tempUser = users.get(user.getUsername());
		if (tempUser != null && tempUser.getPassword().equals(user.getPassword())){
			return true;
		}
		return false;
	}
	
	public boolean createUser(String username, String password){
		
		if(dao.getUsers().get(username) != null){
			return false;
		}
		else{
			dao.addUser(new User(username, password, false));
			return true;
		}
	}
}
