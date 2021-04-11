package com.rj.bd.utils;

import com.rj.bd.admin.controller.AdminController;
import com.rj.bd.admin.entity.Admin;

public class TestDao {
	public static void main(String[] args) {
		AdminController adminController = new AdminController();
		Admin admin = new Admin();
		admin.setA_id("123123");
		admin.setA_name("123123");
		System.out.println(adminController.add(admin));
	}
}
