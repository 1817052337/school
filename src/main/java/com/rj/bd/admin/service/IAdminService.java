package com.rj.bd.admin.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IAdminService {

	Map<String, Object> queryLogin(@Param("userName")String userName, @Param("password")String password);

	void saveToken(String token);



}
