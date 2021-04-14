package com.rj.bd.position.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.position.entity.Position;
import com.rj.bd.position.service.IPositionService;
import com.rj.bd.student.entity.Student;
import com.rj.bd.utils.HttpServletUtils;
import com.rj.bd.utils.JsonUtils;




/**
 * @desc Position模块的控制器
 */
@Controller
@CrossOrigin
@RequestMapping("/position")
public class PositionController {
	
	@Autowired //自动装配
	public IPositionService positionService;
	
	//查询全部
	@RequestMapping("/query")
	public void queryPosition(HttpServletRequest request) throws IOException{
		
		System.out.println("=========queryPosition开始查询全部=========");
		
		
		PrintWriter writer = HttpServletUtils.getHttpServletWriter();
		try {
			//查询实体类的数据
			List<Position> list = positionService.queryAll();
			
			System.out.println(list);
			
			if (list == null || list.size() == 0) {
				JsonUtils.sendJson(writer, -1, "暂无学生", null);
			} else {
				
				JsonUtils.sendJson(writer, 200, "请求成功", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}

	}
	
		
	/**
	 * @desc 保存添加页面的值
	 * @param u
	 * @return
	 * @throws IOException 
	 */
	
	@ResponseBody //将java对象转为json格式的数据
	@CrossOrigin
	@RequestMapping("/add")	
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
	System.out.println("-------add()  === 进入Position保存添加页面的数据------》");
	
	
	
	 String p_name = request.getParameter("p_name");
	 String p_nature =request.getParameter("p_nature");
	 String p_strattime = request.getParameter("p_strattime");
	 String p_review = request.getParameter("p_review");
	 String e_id =request.getParameter("e_id");
	 String s_id = request.getParameter("s_id");
	 String c_id = request.getParameter("c_id");
	 
	 Position po = new Position();
	 
	 
	
	 
}	
//	
	
	

//	/**
//	 * @desc 进入修改页面
//	 * @param request
//	 * @param s_id
//	 * @return
//	 * @throws IOException 
//	 */
//	@RequestMapping("/editPage")
//	
//		public void editPage(HttpServletRequest request,@PathVariable String s_id) throws IOException{
//		
//		System.out.println("==============进入修改页面=============");
//		
//		PrintWriter writer=HttpServletUtils.getHttpServletWriter();
//		
//		System.out.println(s_id);
//		int id = Integer.parseInt(s_id);
//		System.out.println(id);
//		 try {
//				List<Student> list = positionService.queryById(id);
//				if(list == null || list.size() == 0){
//					JsonUtils.sendJson(writer, -1, "id错误", null);
//					return;
//				}
//				else{
//					JsonUtils.sendJson(writer, 200, "请求成功", list);
//					return;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				writer.flush();
//				writer.close();
//			}
//	}
//	
//		/**
//		 * @desc  保存修改页面的值
//		 * @param student
//		 */
//	
//		@RequestMapping("/edit")
//		public Map<String, Object> edit(HttpServletRequest request){
//			
//			System.out.println("==============保存修改=============");
//			
//			Map<String, Object> json = new HashMap<String, Object>();
//			
//			String s_name = request.getParameter("s_name");
//			String s_school = request.getParameter("s_school");
//			String s_age = request.getParameter("s_age");
//			String s_sex = request.getParameter("s_sex");
//			String s_phone = request.getParameter("s_phone");
//			String s_address = request.getParameter("s_address");
//			
//		
//			
//			Student stu = new Student();
//			stu.setS_name(s_name);
//			stu.setS_school(s_school);
//			stu.setS_age(Integer.parseInt(s_age));
//			stu.setS_sex(s_sex);
//			stu.setS_phone(s_phone);
//			stu.setS_address(s_address);
//			
//			positionService.updateStudent(stu);
//			
//			json.put("code", "200");
//			json.put("msg", "请求成功");
//			
//			return json;
//		}
//		
//		
//		
//		
//		/**
//		 * @desc 删除
//		 * @param s_id
//		 * @return
//		 * @throws IOException 
//		 */
//		@RequestMapping("/delete")
//		public void delete(String s_id) throws IOException{
//			PrintWriter writer=HttpServletUtils.getHttpServletWriter();
//			System.out.println(s_id);
//			System.out.println("删除");
//			//没有接收到数值
//			if(s_id == null || s_id.equals("")){
//				JsonUtils.sendJson(writer, -1, "非法请求", null);
//				return;
//			}
//			
//			positionService.deleteById(s_id);
//			JsonUtils.sendJson(writer, 200, "请求成功", null);
//			return;
//			
//		}
//	
}
