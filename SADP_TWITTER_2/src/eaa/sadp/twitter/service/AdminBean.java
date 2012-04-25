package eaa.sadp.twitter.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.User;

@Named
@SessionScoped
public class AdminBean implements Serializable{
	
	@Inject
	Service s;
	
	User selectedUser;
	
	public AdminBean(){
		
	}
	
	public void setSelectedUser(User selectedUser){
		this.selectedUser = selectedUser;
	}
	
	public User getSelectedUser(){
		return this.selectedUser;
	}
	
	public void destroyUser(){
		s.deleteUser(selectedUser.getUsername());
	}
	
	public String editUser(){
		System.out.println(selectedUser);
		if(selectedUser != null){
			return "edit";
		}
		else{
			return "error";
		}
	}
}
