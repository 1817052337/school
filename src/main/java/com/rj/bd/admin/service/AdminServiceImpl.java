package com.rj.bd.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.admin.dao.AdminMapper;
@Transactional
@Service("AdminService") 
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper AdminMapper;

	public void login(String a_id, String a_name) {
		AdminMapper.login(a_id,a_name);
		
	}


}
