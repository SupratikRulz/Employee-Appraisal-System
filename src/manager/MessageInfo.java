package manager;

import java.io.Serializable;

public class MessageInfo implements Serializable{
	
	private String id;
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public MessageInfo(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	
	

}
