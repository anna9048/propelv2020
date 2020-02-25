package com.mvc.bean;

import java.util.Date;

public class RegisterBean {
	//Instance variable
	private Integer id;
	private String fullName,email,userName,password;
	private String active;
	private String roleId,gender;
	private Date regDate;
	
	//Default constructor
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public RegisterBean(String fullName, String email, String userName,
			String password, String active, String roleId, String gender,
			Date regDate) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roleId = roleId;
		this.gender = gender;
		this.regDate = regDate;
	}

	//parameterized constructor 
	public RegisterBean(Integer id, String fullName, String email,
			String userName, String password, String active, String roleId,
			String gender, Date regDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roleId = roleId;
		this.gender = gender;
		this.regDate = regDate;
	}

	//setters and getters
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	//to string method
	@Override
	public String toString() {
		return "RegisterBean [slNo=" + id + ", fullName=" + fullName
				+ ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", active=" + active + ", roleId=" + roleId
				+ ", gender=" + gender + ", regDate=" + regDate + "]";
	}

	
	
	
}
