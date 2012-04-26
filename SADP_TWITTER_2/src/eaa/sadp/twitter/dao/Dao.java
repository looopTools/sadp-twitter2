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
		
		
		// add a few initial users and posts
		User lars = new User("lars", "1212", true);
		User malik = new User("malik", "test", true);
		User martin = new User("martin", "test", false);
		User daniel = new User("daniel", "test", false);
		
		lars.addFollowing(malik);
		lars.addFollowing(martin);
		malik.addFollowing(lars);
		malik.addFollowing(daniel);
		martin.addFollowing(daniel);
		daniel.addFollowing(martin);
		
		addUser(lars);
		addPost(new Post("Working on the admin page", lars));
		addPost(new Post("Still haven't succeeded in getting Malik to change to BSD! :(", lars));
		addPost(new Post("That f***ing admin page won't work!", lars));
		
		addUser(malik);
		addPost(new Post("Just got the users stream page to work. :)", malik));
		addPost(new Post("I just change to Fedora.", malik));
		addPost(new Post("So far quite satisfied with Fedora", malik));
		
		addUser(martin);
		addPost(new Post("Kører nu Xubuntu", martin));
		addPost(new Post("Ahh, kaffe på computeren!", martin));
		
		addUser(daniel);
		addPost(new Post("Ny bærbar i fødselsdagsgave.", daniel));
		addPost(new Post("Vi skal lave et spil i CNDS.", daniel));
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