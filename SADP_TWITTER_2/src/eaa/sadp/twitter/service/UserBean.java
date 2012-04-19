package eaa.sadp.twitter.service;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserBean implements Serializable {

	private String name, password;
	
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
		//String dir = "error";
		
		if(name.equals("lars") && password.equals("1212")){
			return "index";
		}else{
			return "error";
		}
		
	}
	
	
}
