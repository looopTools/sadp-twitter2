package eaa.sadp.twitter.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.model.Post;

@Named
@SessionScoped
public class PostBean implements Serializable {
	
	private String context, username;
	@Inject
	private Service service;
	@Inject
	private PostsTest postsTest;
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
	
	public String commit(){
		postsTest.addPost(new Post(context, userBean.getUser().get(userBean.getName())));
		if(service.addPost(username, context)){
			context = "";
			return "user";
		}else{
			return "error";
		}
	}
}
