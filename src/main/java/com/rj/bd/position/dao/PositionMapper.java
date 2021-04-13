package com.rj.bd.position.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.position.entity.Position;
import com.rj.bd.student.entity.Student;

/**
 * 
 * @desc studentMapper模块的持久层
 *
 */
@Repository("positionMapper") // 该注解标识出当前的接口/模块即是持久层(Dao),StudentMapper说明当前这个是Admin模块的Dao,即可以理解为AdminDao
// 等价的代码：<bean id="StudentMapper" class="代理类(studentMapperProxy)"/>
public interface PositionMapper {

	//查询全部数据
	@Select("  select * from position   ")
	public List<Position> fiandAll();

	

	//查询所有
	@Select("  select * from position")
	public List<Position> queryAll();
	
	
	
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
	@Delete("delete from student where s_id=#{s_id}")
	public void deleteById(String id);
	

}
