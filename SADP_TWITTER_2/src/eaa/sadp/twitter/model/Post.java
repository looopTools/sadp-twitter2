package eaa.sadp.twitter.model;

public class Post {
	
	
	public String context; //Max length 280 chars
	public User user;
	
	public Post(){
		
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
