package admin.com.oracle.amuz.model.javabean;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	private int userid;
	private String username;
	private String password;
	private String actor;
	private Set<Authority> authority;
	private int phonenum;
	private String email;
	private String sex;
	private int loginednum;
	private String loginedIP;
	private String loginedtime;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Set<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	public int getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getLoginednum() {
		return loginednum;
	}
	public void setLoginednum(int loginednum) {
		this.loginednum = loginednum;
	}
	public String getLoginedIP() {
		return loginedIP;
	}
	public void setLoginedIP(String loginedIP) {
		this.loginedIP = loginedIP;
	}
	public String getLoginedtime() {
		return loginedtime;
	}
	public void setLoginedtime(String loginedtime) {
		this.loginedtime = loginedtime;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	private String other;
	public User(int userid, String username, String password, String actor, Set<Authority> authority, int phonenum,
			String email, String sex, int loginednum, String loginedIP, String loginedtime, String other) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.actor = actor;
		this.authority = authority;
		this.phonenum = phonenum;
		this.email = email;
		this.sex = sex;
		this.loginednum = loginednum;
		this.loginedIP = loginedIP;
		this.loginedtime = loginedtime;
		this.other = other;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", actor=" + actor
				+ ", authority=" + authority + ", phonenum=" + phonenum + ", email=" + email + ", sex=" + sex
				+ ", loginednum=" + loginednum + ", loginedIP=" + loginedIP + ", loginedtime=" + loginedtime
				+ ", other=" + other + "]";
	}
	
	
	
}
