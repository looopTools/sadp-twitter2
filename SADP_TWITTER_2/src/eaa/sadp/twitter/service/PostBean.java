package eaa.sadp.twitter.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PostBean implements Serializable {
	
	private String context, username;
	@Inject
	private Service service;
	
	public PostBean(){
		username = "lars"; //TODO: Change from a static version later
		
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String commit(){
		if(service.addPost(username, context)){
			return "index";
		}else{
			return "error";
		}
	}
}
