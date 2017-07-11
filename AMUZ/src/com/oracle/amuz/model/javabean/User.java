package com.oracle.amuz.model.javabean;

import java.io.Serializable;

public class User implements Serializable	{
	private int user_id;
	private String username;
	private String password;
	private String sex;
	private String truename;
	private int address_id;
	private String headimg;
	private String status;
	private String email;
	private String emailstatus;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailstatus() {
		return emailstatus;
	}
	public void setEmailstatus(String emailstatus) {
		this.emailstatus = emailstatus;
	}
	public User(int user_id, String username, String password, String sex, String truename, int address_id,
			String headimg, String status, String email, String emailstatus) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.truename = truename;
		this.address_id = address_id;
		this.headimg = headimg;
		this.status = status;
		this.email = email;
		this.emailstatus = emailstatus;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", truename=" + truename + ", address_id=" + address_id + ", headimg=" + headimg + ", status="
				+ status + ", email=" + email + ", emailstatus=" + emailstatus + "]";
	}
	
	
}
