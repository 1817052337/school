package com.rj.bd.admin.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.admin.dao.AdminMapper;
@Transactional
@Service("AdminService") 
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper AdminMapper;

	public Map<String, Object> queryLogin(@Param("userName")String userName, @Param("password")String password) {
		
		return AdminMapper.queryLogin(userName,password);
	}

	public void saveToken(String token) {
		AdminMapper.saveToken(token);
	}



}
