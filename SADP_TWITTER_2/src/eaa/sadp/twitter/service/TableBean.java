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
	
	private List<User> users;
	@Inject
	Service s;
	public TableBean(){
		
		
		users = new ArrayList<User>();
		setUpdata();
		 
	}
	
	private void setUpdata(){
		HashMap<String, User> cusers = new HashMap<String, User>(s.getUsers());
		ArrayList<String> keyset = new ArrayList(cusers.keySet());
		
		for(String s : keyset){
			users.add(cusers.get(s));
		}
	}
	
	public List<User> getUsers(){
		System.out.println(users);
		return users;
	}

}
