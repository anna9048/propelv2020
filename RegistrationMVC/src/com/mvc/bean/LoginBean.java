package com.mvc.bean;

public class LoginBean {
	
	// Instance Variables
	private String userName,password;
	
	//Default Constructor
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor to pass value to bean
	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	//Setters and getters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//to string method
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password
				+ "]";
	}
	
	

}
