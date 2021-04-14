package com.rj.bd.position.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.position.dao.PositionMapper;
import com.rj.bd.position.entity.Position;
import com.rj.bd.student.entity.Student;

@Transactional
@Service("positionService") // 该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为AdminService
// 等价的代码：<bean id="AdminService"
// class="pro.yf.bj.Admin.service.AdminServiceImpl"/>
public class PositionServiceImpl implements IPositionService {

	@Autowired //自动装配
	private PositionMapper positionMapper;

	//查询所有
	public List<Position> findAll() {
		return positionMapper.fiandAll();
	}
	
	//保存
	public void save(Position po) {
		positionMapper.save(po);
	}
	
	
	// 根据ID查询
	public List<Student> queryById(int s_id) {
		return (List<Student>) positionMapper.queryById(s_id);
	}
	
	//修改
	public void updateStudent(Student student) {
		positionMapper.updateStudent(student);
	}
	
	//删除
	public void deleteById(String s_id) {
		positionMapper.deleteById(s_id);
		
		
	}

	//查询所有
	public List<Position> queryAll() {
		return positionMapper.queryAll();
	}

	

	



}
