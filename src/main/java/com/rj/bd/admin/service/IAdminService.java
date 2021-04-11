package com.rj.bd.admin.service;

import java.util.List;

import com.rj.bd.admin.entity.Admin;

public interface IAdminService {

	public List<Admin>  findAll();

	public void save(Admin u);

	public void deleteById(String id);

	public void update(Admin t);

	public Admin findById(String id);
}
