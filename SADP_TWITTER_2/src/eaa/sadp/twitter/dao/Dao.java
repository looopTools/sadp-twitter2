package eaa.sadp.twitter.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import eaa.sadp.twitter.model.Post;
import eaa.sadp.twitter.model.User;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class Dao implements Serializable{
	
	private Map<String, User> users;
	private Map<String, Post> posts;
	
	public Dao(){
		// String is username and User is the user with that username
		users = new HashMap<String, User>();
		// String is username and Post is the post
		posts = new HashMap<String, Post>();
		users.put("lars", new User("lars", "1212", true));
		users.put("malik", new User("malik", "test", true));
	}
	
	public Map<String, User> getUsers(){
		return new HashMap<String, User>(users);
	}
	
	public void addUser(User user){
		users.put(user.getUsername(), user);
	}
	
	public void deleteUSer(String userName){
		users.remove(userName);
	}

	public Map<String, Post> getPosts() {
		return new HashMap<String, Post>(posts);
	}
	
	public void addPost(Post post){
		posts.put(post.getUser().getUsername(), post);
	}

	
}