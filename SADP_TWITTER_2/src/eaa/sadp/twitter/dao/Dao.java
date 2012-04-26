package eaa.sadp.twitter.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import eaa.sadp.twitter.model.Post;
import eaa.sadp.twitter.model.User;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class Dao implements Serializable{
	
	private Map<String, User> users;
	private Map<String, List<Post>> posts;
	
	public Dao(){
		// String is username and User is the user with that username
		users = new HashMap<String, User>();
		// String is username and Post is the post
		posts = new HashMap<String, List<Post>>();
		
		User lars = new User("lars", "1212", true);
		User malik = new User("malik", "test", true);
		
		lars.addFollowing(malik);
		malik.addFollowing(lars);
		
		addUser(lars);
		addPost(new Post("Still haven't succeeded in getting Malik to change to BSD! :(", lars));
		
		addUser(malik);
		addPost(new Post("I just change to Fedora.", malik));
	}
	
	public Map<String, User> getUsers(){
		return new HashMap<String, User>(users);
	}
	
	public void addUser(User user){
		users.put(user.getUsername(), user);
		posts.put(user.getUsername(), new ArrayList<Post>());
	}
	
	public void deleteUSer(String userName){
		users.remove(userName);
	}

	public Map<String, List<Post>> getPosts() {
		return new HashMap<String, List<Post>>(posts);
	}
	
	public void addPost(Post post){
		posts.get(post.getUser().getUsername()).add(post);
	}

	public List<Post> getPostsForUsers(Set<User> following) {
		List<Post> concatenatedPosts = new ArrayList<Post>();
		for (User u: following){
			concatenatedPosts.addAll(posts.get(u.getUsername()));
		}
		return concatenatedPosts;
	}

	
}