package com.rj.bd.admin.service;

import java.util.Map;

public interface IAdminService {

	Map<String, Object> queryLogin(String userName, String password);

	void saveToken(String token);



}
