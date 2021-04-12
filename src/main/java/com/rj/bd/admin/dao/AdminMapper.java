package com.rj.bd.admin.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 
 * @desc Admin模块的持久层
 *
 */
@Repository("AdminMapper")
public interface AdminMapper {
	@Select("select * from")
	void login(String a_id,String a_name);
}
