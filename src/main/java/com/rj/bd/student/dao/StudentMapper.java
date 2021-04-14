package com.rj.bd.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.student.entity.Student;

/**
 * 
 * @desc studentMapper模块的持久层
 *
 */
@Repository("studentMapper") // 该注解标识出当前的接口/模块即是持久层(Dao),StudentMapper说明当前这个是Admin模块的Dao,即可以理解为AdminDao
// 等价的代码：<bean id="StudentMapper" class="代理类(studentMapperProxy)"/>
public interface StudentMapper {

	//查询全部数据
	@Select("  select * from student   ")
	public List<Student> fiandAll();

	//添加
	@Insert("insert into student (s_id,s_name,s_school,s_age,s_sex,s_phone,s_address) values (#{s_id},#{s_name}"
			+ ",#{s_school},#{s_age},#{s_sex},#{s_phone},#{s_address})")
	public void save(Student stu);

	//根据ID查询
	@Select("select * from student where s_id=#{s_id}")
	public List<Student> queryById(int id);
	
	//修改
	@Update("update student set s_name=#{s_name},s_school=#{s_school},s_age=#{s_age}"
			+ ",s_sex=#{s_sex},s_phone=#{s_phone},s_address=#{s_address} where s_id=#{s_id}")
	public void updateStudent(Student student);
	
	
	//删除
	@Delete("delete from position where s_id=#{s_id}")
	public void deleteById(String id);
	
	//删除student表
	@Delete("delete from student where s_id=#{s_id}")
	public void deleteSById(String id);
	
	
	
	//查询所有
	@Select("  select * from student")
	public List<Student> queryAll();

}
