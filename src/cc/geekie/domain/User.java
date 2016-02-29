package cc.geekie.domain;

import java.io.Serializable;

public class User implements Serializable {
	
	private String username;
	private String password;
	private String email;
	private String id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User(String username, String password, String email, String id) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
	}
	public User() {}


}
