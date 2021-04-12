package com.rj.bd.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/ceshi")
	public void ceshi() {
		System.out.println("测试路径");
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException, ClassNotFoundException, SQLException
	{
		response.setHeader("Access-Control-Allow-Origin", "*");//*允许任何域
	    response.setHeader("Access-Control-Allow-Credentials", "true"); 
	    response.setHeader("Access-Control-Allow-Methods", "*");
	    response.setHeader("Access-Control-Max-Age", "999999");
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
	    System.out.println("userName:"+userName);
	    System.out.println("password:"+password);
	    
	    //查询数据库中用户名和密码，如果有就返回成功，前台转向成功页面，如果没有就返回失败
	    Map<String, Object> map=adminService.queryLogin(userName,password);
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    ObjectMapper objectMapper=new ObjectMapper();
	    String json="";
	    if (map!=null) 
	    {
	      //将产生的token值存入到返回的json串中
	      String token=UUID.randomUUID().toString()+"_"+userName+"_"+password;//产生一个token值
	      //为了以后登录的时候能够比对成功，所以需要将token值保持到mysql数据库中
	      adminService.saveToken(token);
	      json =objectMapper.writeValueAsString("{\"code\":\"1\",\"msg\":\"登录成功，跳转到index.html页面\",\"myToken\":\""+token+"\"}");
	    }
	    else
	    {
	    	//因为登录不成功，所以不用产生token值
	    	json =objectMapper.writeValueAsString("{\"code\":\"2\",\"msg\":\"登录失败：跳转到error.html页面\"}");
	    }
	    PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
