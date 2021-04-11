package com.rj.bd.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.admin.entity.Admin;

/**
 * 
 * @desc Admin模块的持久层
 *
 */
@Repository("AdminMapper") // 该注解标识出当前的接口/模块即是持久层(Dao),AdminMapper说明当前这个是Admin模块的Dao,即可以理解为AdminDao
// 等价的代码：<bean id="AdminMapper" class="代理类(AdminMapperProxy)"/>
public interface AdminMapper {

	@Select("  select * from Admin   ")
	public List<Admin> fiandAll();

	@Insert("insert into Admin (t_id,t_name) values (#{t_id},#{t_name})")
	public void save(Admin u);

	@Delete("delete from Admin where t_id=#{t_id}")
	public void delete(String id);

	@Update("update Admin set t_name=#{t_name} where t_id=#{t_id}")
	public void update(Admin u);

	@Select("select * from Admin where t_id=#{t_id}")
	public Admin findById(String id);
	
}
