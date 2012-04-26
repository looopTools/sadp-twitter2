package eaa.sadp.twitter.model;

public class Post implements Comparable<Post>{
	
	
	private String context; //Max length 280 chars
	private User user;
	private long timestamp;
	
	public Post(String context, User user){
		this.context = context;
		this.user = user;
		setTimestamp(System.currentTimeMillis());
	}

	@Override
	public int compareTo(Post otherPost) {
		int result = 0;
		if (getTimestamp() >= otherPost.getTimestamp()){
			result = -1;
		} else {
			result = 1;
		}
		return result;
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}	

}
