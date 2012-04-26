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

	public boolean isNewAdmin() {
		return newAdmin;
	}

	public void setNewAdmin(boolean newAdmin) {
		this.newAdmin = newAdmin;
	}

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public void updateUser(){

		if(newPassword.equals("")){
			selectedUser.setAdmin(newAdmin);
			selectedUser.setUsername(newUsername);
		}
		else if(newUsername.equals("")){
			selectedUser.setAdmin(newAdmin);
			selectedUser.setPassword(newPassword);
		}else if(newUsername.equals("") && newPassword.equals("")){
			selectedUser.setAdmin(newAdmin);
		}else{
			selectedUser.setAdmin(newAdmin);
			selectedUser.setPassword(newPassword);
			selectedUser.setUsername(newUsername);
		}
		
		
	}
	
	public String cancel(){
		return "admin";
	}
}
