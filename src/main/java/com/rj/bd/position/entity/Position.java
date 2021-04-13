package com.rj.bd.position.entity;

/**
 * Position的实体类
 * @author YuanJinTao
 * @date 2021年4月13日
 */

public class Position {
	public int p_id;
	
	public String p_name;
	
	public String p_nature;
	
	public String p_strattime;
	
	public String p_review;
	
	public int e_id;
	
	public int s_id;
	
	public int c_id;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_nature() {
		return p_nature;
	}

	public void setP_nature(String p_nature) {
		this.p_nature = p_nature;
	}

	public String getP_strattime() {
		return p_strattime;
	}

	public void setP_strattime(String p_strattime) {
		this.p_strattime = p_strattime;
	}

	public String getP_review() {
		return p_review;
	}

	public void setP_review(String p_review) {
		this.p_review = p_review;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public String toString() {
		return "Position [p_id=" + p_id + ", p_name=" + p_name + ", p_nature=" + p_nature + ", p_strattime="
				+ p_strattime + ", p_review=" + p_review + ", e_id=" + e_id + ", s_id=" + s_id + ", c_id=" + c_id + "]";
	}
	
	
	
	
	
	
	
	
	
}
