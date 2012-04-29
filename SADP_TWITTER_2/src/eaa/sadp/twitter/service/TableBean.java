package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.User;

@Named
@SessionScoped
public class TableBean implements Serializable{
	
	@Inject
	Service s;
	@Inject
	UserBean userBean;
	
	public TableBean(){
		
	}
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>(s.getUsers().values());
		users.remove(userBean.getUser());
		return users;
	}

}
