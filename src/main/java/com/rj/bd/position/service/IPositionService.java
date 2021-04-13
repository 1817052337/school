package com.rj.bd.position.service;

import java.util.List;

import com.rj.bd.position.entity.Position;
import com.rj.bd.student.entity.Student;

/**
 * @desc IStudentService接口类
 * @author YuanJinTao
 * @date 2021年4月12日
 */
public interface IPositionService {

	//fk查询所有
	public List<Position>  findAll();
	
	
	//查询全部
	public List<Position>  queryAll();
	
	
	//保存
	public void save(Student stu);

	//根据ID查询
	public List<Student> queryById(int s_id);

	//修改页面的值
	public void updateStudent(Student student);

	//根据ID删除
	public void deleteById(String s_id);
}
