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
//		setUpdata();
		 
	}
	
	private void setUpdata(){
		
		ArrayList<User> keyset = new ArrayList(s.getUsers().values());
		
		for(User u : keyset){
			users.add(u);
		}
	}
	
	public List<User> getUsers(){
//		System.out.println(users);
//		return users;
		return new ArrayList<User>(s.getUsers().values());
	}

}
