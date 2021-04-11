package com.rj.bd.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.admin.dao.AdminMapper;
import com.rj.bd.admin.entity.Admin;
@Transactional
@Service("AdminService") // 该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为AdminService
// 等价的代码：<bean id="AdminService"
// class="pro.yf.bj.Admin.service.AdminServiceImpl"/>
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper AdminMapper;

	public List<Admin> findAll() {

		return AdminMapper.fiandAll();
	}

	public void save(Admin u) {
		AdminMapper.save(u);
	}

	public void deleteById(String id) {
		AdminMapper.delete(id);
	}

	public Admin findById(String id) {
		Admin t = AdminMapper.findById(id);
		return t;
	}

	public void update(Admin t) {
		AdminMapper.update(t);

	}

}
