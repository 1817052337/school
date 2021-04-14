package com.rj.bd.enterprise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.enterprise.entity.Enterprise;

/**
 * 
 * @desc EnterpriseMapper模块的持久层
 *
 */
@Repository("EnterpriseMapper") // 该注解标识出当前的接口/模块即是持久层(Dao),EnterpriseMapper说明当前这个是Admin模块的Dao,即可以理解为AdminDao
// 等价的代码：<bean id="EnterpriseMapper" class="代理类(EnterpriseMapperProxy)"/>
public interface EnterpriseMapper {

	//查询全部数据
	@Select("  select * from Enterprise   ")
	public List<Enterprise> fiandAll();

	//添加
	@Insert("insert into Enterprise (s_id,s_name,s_school,s_age,s_sex,s_phone,s_address) values (#{s_id},#{s_name}"
			+ ",#{s_school},#{s_age},#{s_sex},#{s_phone},#{s_address})")
	public void save(Enterprise stu);

	//根据ID查询
	@Select("select * from Enterprise where s_id=#{s_id}")
	public List<Enterprise> queryById(int id);
	
	//修改
	@Update("update Enterprise set s_name=#{s_name},s_school=#{s_school},s_age=#{s_age}"
			+ ",s_sex=#{s_sex},s_phone=#{s_phone},s_address=#{s_address} where s_id=#{s_id}")
	public void updateEnterprise(Enterprise Enterprise);
	
	
	//删除
	@Delete("delete from Enterprise where s_id=#{s_id}")
	public void deleteById(String id);
	
	//查询所有
	@Select("  select * from Enterprise")
	public List<Enterprise> queryAll();

}
