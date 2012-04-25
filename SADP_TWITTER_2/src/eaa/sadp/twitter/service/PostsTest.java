package eaa.sadp.twitter.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import eaa.sadp.twitter.model.Post;
import eaa.sadp.twitter.model.User;

@Named
@SessionScoped
public class PostsTest implements Serializable {
	
	private List<Post> posts;

	public PostsTest(){
		posts = new ArrayList<Post>();
		User usr1 = new User("malik", "test", false);
		User usr2 = new User("lars", "1212", false);
		posts.add(new Post("Hello world!", usr1));
		posts.add(new Post("lars is 1337", usr2));
		posts.add(new Post("Windows sucks!!", usr2));
	}
	
	public List<Post> getPosts(){
		return new ArrayList<Post>(posts);
	}
	
	public void addPost(Post post){
		posts.add(post);
	}
}
