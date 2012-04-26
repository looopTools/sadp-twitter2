package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import eaa.sadp.twitter.dao.Dao;
import eaa.sadp.twitter.model.Post;
import eaa.sadp.twitter.model.User;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class Service implements Serializable{

	@Inject
	private Dao dao;
	
	public User verifyUser(User user){
		Map<String, User> users = dao.getUsers();
		User tempUser = users.get(user.getUsername());
		if (tempUser != null && tempUser.getPassword().equals(user.getPassword())){
			return tempUser;
		}
		return null;
	}
	
	public boolean createUser(String username, String password){
		
		if(dao.getUsers().get(username) != null){
			return false;
		}
		else{
			dao.addUser(new User(username, password, false));
			return true;
		}
	}
	
	public boolean addPost(String username, String context){
		User user = dao.getUsers().get(username); 
		
		if(user != null){
			
			dao.addPost(new Post(context, user));
			return true;
		}
		else{
			return false;
		}
	}
	
	public Map<String, User> getUsers(){
		return dao.getUsers();
	}
	
	public void deleteUser(String userName){
		dao.deleteUSer(userName);
	}

	public List<Post> getTop(int maxNumberOfPosts, User user) {
		List<Post> sortedPosts = dao.getPostsForUsers(user.getFollowing());
		Collections.sort(sortedPosts);
		return sortedPosts.size() > maxNumberOfPosts? sortedPosts.subList(0, maxNumberOfPosts) : sortedPosts;
	}
}
