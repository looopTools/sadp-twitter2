package eaa.sadp.twitter.model;

public class Post {
	
	
	public String context; //Max length 280 chars
	public User user;
	
	public Post(String context, User user){
		this.context = context;
		this.user = user;
		
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

}
