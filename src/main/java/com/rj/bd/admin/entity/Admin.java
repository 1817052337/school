package com.rj.bd.admin.entity;

/**
 * 
 @desc Admin模块的实体类
 * 
 */
public class Admin {
	private String a_id;
	private String a_username;
	private String a_password;
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_username() {
		return a_username;
	}
	public void setA_username(String a_username) {
		this.a_username = a_username;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", a_username=" + a_username + ", a_password=" + a_password + "]";
	}
	
}
