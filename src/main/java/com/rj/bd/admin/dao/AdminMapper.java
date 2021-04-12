package com.rj.bd.admin.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 
 * @desc Admin模块的持久层
 *
 */
@Repository("AdminMapper")
public interface AdminMapper {
		
	@Select("select * from admin where a_username=#{userName} and a_password=#{password}")
	public Map<String, Object> queryLogin(String userName, String password);
	
	@Insert("insert into set(t_id,t_token) values (0,#{t_token})")
	public void saveToken(String token);
}
