package com.ap4b.model;

public class Teacher {
	private int id;
	private String username;
	private String password;
	private String mode;
	
	
	public Teacher() {
		super();
		
	}
	
	public Teacher(int id, String username, String password, String mode) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mode = mode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getMode() {
		return mode;
	}
	public void setMode(String Mode) {
		this.mode = mode;
	}
	

}
