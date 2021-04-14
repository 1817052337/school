package com.rj.bd.enterprise.entity;

/**
 * Position的实体类
 * @author YuanJinTao
 * @date 2021年4月13日
 */

public class Enterprise {
	public int e_id;
	
	public String e_name;
	
	public String e_path;
	
	public String e_filepath;
	
	public String e_filename;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_path() {
		return e_path;
	}

	public void setE_path(String e_path) {
		this.e_path = e_path;
	}

	public String getE_filepath() {
		return e_filepath;
	}

	public void setE_filepath(String e_filepath) {
		this.e_filepath = e_filepath;
	}

	public String getE_filename() {
		return e_filename;
	}

	public void setE_filename(String e_filename) {
		this.e_filename = e_filename;
	}

	@Override
	public String toString() {
		return "Enterprise [e_id=" + e_id + ", e_name=" + e_name + ", e_path=" + e_path + ", e_filepath=" + e_filepath
				+ ", e_filename=" + e_filename + "]";
	}
	
	
	
	
}
