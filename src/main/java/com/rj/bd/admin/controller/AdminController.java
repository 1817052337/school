package com.rj.bd.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.bd.admin.service.IAdminService;

/**
 * @desc Admin模块的控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public IAdminService adminService;
	
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/login")
	public void login(HttpServletResponse response,@Param("userName")String userName,@Param("password")String password) throws JsonGenerationException, JsonMappingException, IOException, ClassNotFoundException, SQLException
	{
		System.out.println(userName);
		System.out.println(password);
	    Map<String, Object> map=adminService.queryLogin(userName,password);
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    ObjectMapper objectMapper=new ObjectMapper();
	    String json="";
	    if (map!=null) 
	    {
	      String token=UUID.randomUUID().toString()+"_"+userName+"_"+password;//产生一个token值
	      adminService.saveToken(token);
	      json =objectMapper.writeValueAsString("{\"code\":\"1\",\"msg\":\"登录成功，跳转到index.html页面\",\"myToken\":\""+token+"\"}");
	    }
	    else
	    {
	    	json =objectMapper.writeValueAsString("{\"code\":\"2\",\"msg\":\"登录失败：跳转到error.html页面\"}");
	    }
	    PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
