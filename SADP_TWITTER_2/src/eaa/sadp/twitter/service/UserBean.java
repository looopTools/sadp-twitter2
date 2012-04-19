package eaa.sadp.twitter.service;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.User;

@Named
@ApplicationScoped
public class UserBean implements Serializable {

	private String name, password;
	@Inject
	private Service service;
	
	public UserBean(){
		setName("");
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
		
		if(service.verifyUser(new User(name, password))){
			return "index";
		}else{
			return "error";
		}
		
	}
	
	
}
