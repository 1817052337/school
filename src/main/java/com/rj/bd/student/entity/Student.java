package com.rj.bd.student.entity;

/**
 * 
 @desc student模块的实体类
 * 
 */

public class Student {
	
	
	public int s_id;
	
	public String s_name;
	
	public String s_school;
	
	public int s_age;
	
	public String s_sex;
	
	public String s_phone;
	
	public String s_address;

	
	
	
	
	
	public int getS_id() {
		return s_id;
	}






	public void setS_id(int s_id) {
		this.s_id = s_id;
	}






	public String getS_name() {
		return s_name;
	}






	public void setS_name(String s_name) {
		this.s_name = s_name;
	}






	public String getS_school() {
		return s_school;
	}






	public void setS_school(String s_school) {
		this.s_school = s_school;
	}






	public int getS_age() {
		return s_age;
	}






	public void setS_age(int s_age) {
		this.s_age = s_age;
	}






	public String getS_sex() {
		return s_sex;
	}






	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}






	public String getS_phone() {
		return s_phone;
	}






	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}






	public String getS_address() {
		return s_address;
	}






	public void setS_address(String s_address) {
		this.s_address = s_address;
	}






	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_school=" + s_school + ", s_age=" + s_age
				+ ", s_sex=" + s_sex + ", s_phone=" + s_phone + ", s_address=" + s_address + "]";
	}
	
	
	
	
	
}
