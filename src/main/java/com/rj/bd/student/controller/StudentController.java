package com.rj.bd.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.bd.student.entity.Student;
import com.rj.bd.student.service.IStudentService;
import com.rj.bd.utils.HttpServletUtils;
import com.rj.bd.utils.JsonUtils;

/**
 * @desc Student模块的控制器
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public IStudentService studentService;

	// FK查询 查询全部
//	@RequestMapping("/queryfk")
//	public String queryFK(HttpServletRequest request, ModelMap map) {
//
//		System.out.println("========studentController:queryFK()查询全部==========");
//
//		List<Student> list = studentService.findAll();
//
//		System.out.println("--------------->" + list.size());
//
//		// request.setAttribute("list", list);
//		map.addAttribute("list", list);
//		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//				+ request.getContextPath() + "/";
//		map.addAttribute("path", path);
//
//		//
//		for (Student stu : list) {
//			System.out.println(
//					stu.getS_id() + "/t" + stu.getS_name() + "/t" + stu.getS_school() + "/t" + stu.getS_phone());
//		}
//
//		return "student_list_fk";
//	}

	// 查询全部
	@RequestMapping("/query")
	public void queryStuden(HttpServletRequest request) throws IOException {
		PrintWriter writer = HttpServletUtils.getHttpServletWriter();
		try {
			List<Student> list = studentService.queryAll();
			if (list == null || list.size() == 0) {
				JsonUtils.sendJson(writer, -1, "暂无学生", null);
				System.out.println("执行到了武穴市");
			} else {
				JsonUtils.sendJson(writer, 200, "请求成功", list);
				System.out.println("执行到了请求成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("执行到了刷新");
			writer.flush();
			System.out.println("执行到了关闭");
			writer.close();
			System.out.println("执行完了");
		}

	}

	/**
	 * @desc 保存添加页面的值
	 * @param u
	 * @return
	 * @throws IOException
	 */
//	@
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("-------add()=== 保存添加页面的数据------》");
		 String s_name = request.getParameter("s_name");
		 String s_school =request.getParameter("s_school");
		 String s_age = request.getParameter("s_age");
		 String s_sex = request.getParameter("s_sex");
		 String s_phone = request.getParameter("s_phone");
		 String s_address = request.getParameter("s_address");
		 
		 Student student =  new Student();
		 student.setS_address(s_address);
		 student.setS_age(Integer.parseInt(s_age));
		 student.setS_id(0);
		 student.setS_name(s_name);
		 student.setS_phone(s_phone);
		 student.setS_school(s_school);
		 student.setS_sex(s_sex);
		 
		 	response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    ObjectMapper objectMapper=new ObjectMapper();
		    String json="";
		    if (student!=null) 
		    {
		    	studentService.save(student);
		      json =objectMapper.writeValueAsString("{\"code\":\"1\",\"msg\":\"添加成功，跳转到index.html页面\"}");
		    }
		    else
		    {
		    	json =objectMapper.writeValueAsString("{\"code\":\"2\",\"msg\":\"添加失败\"}");
		    }
		    PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		 
	}

	/**
	 * @desc 进入修改页面
	 * @param request
	 * @param s_id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/editPage")

	public void editPage(HttpServletRequest request, String s_id) throws IOException {

		System.out.println("==============进入修改页面=============");

		PrintWriter writer = HttpServletUtils.getHttpServletWriter();

		System.out.println(s_id);
		int id = Integer.parseInt(s_id);
		System.out.println(id);
		try {
			List<Student> list = studentService.queryById(id);
			System.out.println(list);
			
			if (list == null || list.size() == 0) {
				JsonUtils.sendJson(writer, -1, "id错误", null);
				return;
			} else {
				JsonUtils.sendJson(writer, 200, "请求成功", list);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}

	/**
	 * @desc 保存修改页面的值
	 * @param student
	 * @throws IOException 
	 */
	@ResponseBody
	@CrossOrigin
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public void  edit(HttpServletRequest request,HttpServletResponse response) throws IOException {

		System.out.println("==============保存修改=============");
		//从页面取值
		String s_id = request.getParameter("s_id");
		String s_name = request.getParameter("s_name");
		String s_school = request.getParameter("s_school");
		String s_age = request.getParameter("s_age");
		String s_sex = request.getParameter("s_sex");
		String s_phone = request.getParameter("s_phone");
		String s_address = request.getParameter("s_address");
		//将页面的值存入实体类
		Student stu = new Student();
		stu.setS_id(Integer.parseInt(s_id));
		stu.setS_name(s_name);
		stu.setS_school(s_school);
		stu.setS_age(Integer.parseInt(s_age));
		stu.setS_sex(s_sex);
		stu.setS_phone(s_phone);
		stu.setS_address(s_address);
		
	 	response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    ObjectMapper objectMapper=new ObjectMapper();
	    String json="";
	    if (stu!=null) 
	    {
	    	//将实体类传入sql 更新
	    	studentService.updateStudent(stu);
	      json =objectMapper.writeValueAsString("{\"code\":\"1\",\"msg\":\"添加成功，跳转到index.html页面\"}");
	    }
	    else
	    {
	    	json =objectMapper.writeValueAsString("{\"code\":\"2\",\"msg\":\"添加失败\"}");
	    }
	    PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
		
		

//		studentService.updateStudent(stu);


	}

	/**
	 * @desc 删除
	 * @param s_id
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/delete")
	public void delete(@Param("s_id")String s_id,HttpServletResponse response) throws IOException {
		PrintWriter writer = HttpServletUtils.getHttpServletWriter();
		System.out.println(s_id);
		System.out.println("删除");
//		// 没有接收到数值
//		if (s_id == null || s_id.equals("")) {
//			JsonUtils.sendJson(writer, -1, "非法请求", null);
//		}

//		studentService.deleteById(s_id);
//
//		studentService.deleteSById(s_id);

//		JsonUtils.sendJson(writer, 200, "请求成功", null);
		
		
		
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    ObjectMapper objectMapper=new ObjectMapper();
	    String json="";
	    
	    if (s_id!=null) 
	    {
				studentService.deleteById(s_id);
	    		studentService.deleteSById(s_id);
	      json =objectMapper.writeValueAsString("{\"code\":\"1\",\"msg\":\"添加成功，跳转到index.html页面\"}");
	    }
	    else
	    {
	    	json =objectMapper.writeValueAsString("{\"code\":\"2\",\"msg\":\"添加失败\"}");
	    }
	    PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
		

	}

}
