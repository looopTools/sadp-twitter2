package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.Post;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class PostBean implements Serializable {
	
	private String context, username;
	@Inject
	private Service service;
	@Inject
	private UserBean userBean;
	
	public PostBean(){
		username = "lars"; //TODO: Change from a static version later
		context = "";
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
	
	public List<Post> getTop(int maxNumberOfPosts){
		List<Post> posts = service.getTop(maxNumberOfPosts, userBean.getUser());
		return new ArrayList<Post>(posts);
	}
	
	public String commit(){
		if(service.addPost(userBean.getUser().getUsername(), context)){
			context = "";
			return "user";
		}else{
			return "error";
		}
	}
}
