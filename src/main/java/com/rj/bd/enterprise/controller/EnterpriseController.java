package com.rj.bd.enterprise.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rj.bd.enterprise.entity.Enterprise;
import com.rj.bd.enterprise.service.IEnterpriseService;
import com.rj.bd.utils.HttpServletUtils;
import com.rj.bd.utils.JsonUtils;

/**
 * @desc Enterprise模块的控制器
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	private String sid;
	private String path;// 路径

	@Autowired
	public IEnterpriseService EnterpriseService;

	// FK查询 查询全部
	@RequestMapping("/queryfk")
	public String queryFK(HttpServletRequest request, ModelMap map) {

		System.out.println("========EnterpriseController:queryFK()查询全部==========");

		List<Enterprise> list = EnterpriseService.findAll();

		System.out.println("--------------->" + list.size());

		// request.setAttribute("list", list);
		map.addAttribute("list", list);
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		map.addAttribute("path", path);

		//
		for (Enterprise stu : list) {
			System.out.println(
					stu.getS_id() + "/t" + stu.getS_name() + "/t" + stu.getS_school() + "/t" + stu.getS_phone());
		}

		return "Enterprise_list_fk";
	}

	// 查询全部
	@RequestMapping("/query")
	public void queryStuden(HttpServletRequest request) throws IOException {
		PrintWriter writer = HttpServletUtils.getHttpServletWriter();

		try {
			List<Enterprise> list = EnterpriseService.queryAll();
			if (list == null || list.size() == 0) {
				JsonUtils.sendJson(writer, -1, "暂无学生", null);
				System.out.println("执行到了武穴市");
				return;
			} else {
				JsonUtils.sendJson(writer, 200, "请求成功", list);
				System.out.println("执行到了请求成功");
				return;
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
	@RequestMapping("/add")
	public void add(Enterprise stu) throws IOException {
		System.out.println("-------add()  === 保存添加页面的数据------》");

		HttpServletRequest request = HttpServletUtils.getrequest();
		String s_name = request.getParameter("s_name");
		String s_school = request.getParameter("s_school");
		String s_age = request.getParameter("s_age");
		String s_sex = request.getParameter("s_sex");
		String s_phone = request.getParameter("s_phone");
		String s_address = request.getParameter("s_address");
		stu.setS_name(s_name);
		stu.setS_school(s_school);
		stu.setS_age(Integer.parseInt(s_age));
		stu.setS_sex(s_sex);
		stu.setS_phone(s_phone);
		stu.setS_address(s_address);

		EnterpriseService.save(stu);
		return;
	}

	/**
	 * @desc 进入修改页面
	 * @param request
	 * @param s_id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/editPage")

	public void editPage(HttpServletRequest request, @PathVariable String s_id) throws IOException {

		System.out.println("==============进入修改页面=============");

		PrintWriter writer = HttpServletUtils.getHttpServletWriter();

		System.out.println(s_id);
		int id = Integer.parseInt(s_id);
		System.out.println(id);
		try {
			List<Enterprise> list = EnterpriseService.queryById(id);
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
	 * @param Enterprise
	 */

	@RequestMapping("/edit")
	public Map<String, Object> edit(HttpServletRequest request) {

		System.out.println("==============保存修改=============");

		Map<String, Object> json = new HashMap<String, Object>();

		String s_name = request.getParameter("s_name");
		String s_school = request.getParameter("s_school");
		String s_age = request.getParameter("s_age");
		String s_sex = request.getParameter("s_sex");
		String s_phone = request.getParameter("s_phone");
		String s_address = request.getParameter("s_address");

		Enterprise stu = new Enterprise();
		stu.setS_name(s_name);
		stu.setS_school(s_school);
		stu.setS_age(Integer.parseInt(s_age));
		stu.setS_sex(s_sex);
		stu.setS_phone(s_phone);
		stu.setS_address(s_address);

		EnterpriseService.updateEnterprise(stu);

		json.put("code", "200");
		json.put("msg", "请求成功");

		return json;
	}

	/**
	 * @desc 删除
	 * @param s_id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/delete")
	public void delete(String s_id) throws IOException {
		PrintWriter writer = HttpServletUtils.getHttpServletWriter();
		System.out.println(s_id);
		System.out.println("删除");
		// 没有接收到数值
		if (s_id == null || s_id.equals("")) {
			JsonUtils.sendJson(writer, -1, "非法请求", null);
			return;
		}

		EnterpriseService.deleteById(s_id);
		JsonUtils.sendJson(writer, 200, "请求成功", null);
		return;

	}

}
