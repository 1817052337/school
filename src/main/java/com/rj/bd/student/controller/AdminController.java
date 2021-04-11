package com.rj.bd.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rj.bd.Student.service.IStudentService;
/**
 * @desc Student模块的控制器
 */
@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired 
	public IStudentService StudentService;
	//FK查询  未修改
	@RequestMapping("/queryFK")
	public String queryFK(HttpServletRequest request,ModelMap map){
		System.out.println("studentController:queryFK()");
		
	     List<student> list = studentService.findAll();
		
		System.out.println("--------------->"+list.size());
		
		//request.setAttribute("list", list);
		map.addAttribute("list", list);
		String path = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
		map.addAttribute("path", path);
		for (student student : list) {
			System.out.println(student.getId()+"\t"+student.getName());
		}
		
		return "student_list_fk";
	}
	
}
