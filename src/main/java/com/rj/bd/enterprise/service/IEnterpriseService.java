package com.rj.bd.enterprise.service;

import java.util.List;

import com.rj.bd.enterprise.entity.Enterprise;

/**
 * @desc IEnterpriseService接口类
 */
public interface IEnterpriseService {

	// fk查询所有
	public List<Enterprise> findAll();

	// 查询全部
	public List<Enterprise> queryAll();

	// 保存
	public void save(Enterprise stu);

	// 根据ID查询
	public List<Enterprise> queryById(int s_id);

	// 修改页面的值
	public void updateEnterprise(Enterprise Enterprise);

	// 根据ID删除
	public void deleteById(String s_id);
}
