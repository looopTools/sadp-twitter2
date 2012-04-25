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
	
	private User selectedUser;
	
	private boolean newAdmin;
	private String newPassword, newUsername;
	
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
	
	public void setNewAdmin(String newAdmin){
		
		if(newAdmin.equals("true")){
			this.newAdmin = true;
		}
		else if(newAdmin.equals("false")){
			this.newAdmin = false;
		}
	}
	
	public boolean getNewAdmin(){
		return this.newAdmin;
	}
	
	public void setNewUsername(String newUsername){
		this.newUsername = newUsername;
	}
	
	public String getNewUsername(){
		return this.newUsername;
	}
	
	public void setNewPassword(String newPassword){
		
		this.newPassword = newPassword;
	}
}
