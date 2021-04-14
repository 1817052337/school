package com.rj.bd.category.entity;

/**
 * Position的实体类
 * @author YuanJinTao
 * @date 2021年4月13日
 */

public class Category {
	public int c_id;
	
	public String c_name;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "Category [c_id=" + c_id + ", c_name=" + c_name + "]";
	}
	
	
	
	
	
	
}
