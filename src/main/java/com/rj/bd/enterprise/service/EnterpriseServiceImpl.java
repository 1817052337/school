package com.rj.bd.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.enterprise.dao.EnterpriseMapper;
import com.rj.bd.enterprise.entity.Enterprise;

@Transactional
@Service("EnterpriseService") // 该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为AdminService
// 等价的代码：<bean id="AdminService"
// class="pro.yf.bj.Admin.service.AdminServiceImpl"/>
public class EnterpriseServiceImpl implements IEnterpriseService {

	@Autowired // 自动装配
	private EnterpriseMapper EnterpriseMapper;

	// 查询所有
	public List<Enterprise> findAll() {
		return EnterpriseMapper.fiandAll();
	}

	// 保存

	public void save(Enterprise stu) {
		EnterpriseMapper.save(stu);
	}

	// 根据ID查询
	public List<Enterprise> queryById(int s_id) {
		return (List<Enterprise>) EnterpriseMapper.queryById(s_id);
	}

	// 修改
	public void updateEnterprise(Enterprise Enterprise) {
		EnterpriseMapper.updateEnterprise(Enterprise);
	}

	// 删除
	public void deleteById(String s_id) {
		EnterpriseMapper.deleteById(s_id);

	}

	// 查询所有
	public List<Enterprise> queryAll() {
		return EnterpriseMapper.queryAll();
	}

}
