package com.rj.bd.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.student.dao.StudentMapper;
import com.rj.bd.student.entity.Student;

@Transactional
@Service("studentService") // 该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为AdminService
// 等价的代码：<bean id="AdminService"
// class="pro.yf.bj.Admin.service.AdminServiceImpl"/>
public class StudentServiceImpl implements IStudentService {

	@Autowired //自动装配
	private StudentMapper studentMapper;

	//查询所有
//	public List<Student> findAll() {
//		return studentMapper.fiandAll();
//	}
	
	//保存

	public void save(Student stu) {
		 studentMapper.save(stu);
	}
	
	
	// 根据ID查询
	public List<Student> queryById(int s_id) {
		return (List<Student>) studentMapper.queryById(s_id);
	}
	
	//修改
	public void updateStudent(Student student) {
		 studentMapper.updateStudent(student);
	}
	
	//删除
	public void deleteById(String s_id) {
		studentMapper.deleteById(s_id);
		
		
	}
	//删除student表ID
	public void deleteSById(String s_id) {
		studentMapper.deleteSById(s_id);
		
	}
	//查询所有
	public List<Student> queryAll() {
		return studentMapper.queryAll();
	}

	

	

	



}
