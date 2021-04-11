package com.rj.bd.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rj.bd.admin.entity.Admin;
import com.rj.bd.admin.service.IAdminService;
/**
 * @desc Admin模块的控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired 
	public IAdminService AdminService;

	@RequestMapping("/query")
	public String queryAdmin(HttpServletRequest request) {
		System.out.println("AdminController:queryAdmin()");
		List<Admin> list = AdminService.findAll();
		System.out.println("--------------->" + list.size());

		request.setAttribute("list", list);// 将带有数据的list传递给前台的查询展示页面

		for (Admin Admin : list) {
			System.out.println(Admin.getT_id() + "\t" + Admin.getT_name());
		}

		return "table/Admin_list";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		System.out.println("-------进入Admin模块的添加页面------》");
		return "table/Admin_add";
	}

	@RequestMapping("/add")
	public String add(Admin u) {
		System.out.println("-------add()------》");
		u.setT_id(0);
		AdminService.save(u);
		return "redirect:/table/query.action";
	}
	@RequestMapping("/editPage")
	public String editPage(String id,Model model) {
		System.out.println("-------进入Admin模块的修改页面------》");
		Admin Admin = AdminService.findById(id);
		System.out.println(Admin);
		model.addAttribute("table", Admin);
		return "table/Admin_edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model,Admin t) {
		System.out.println("-------edit()------》");
		AdminService.update(t);
		Admin Admin = AdminService.findById(t.getT_id());
		model.addAttribute("table",Admin);
		return "redirect:/table/query.action";
	}
	@RequestMapping("/delete")
	public String delete(String id) {
		System.out.println("-------delete()------》"+id);
		AdminService.deleteById(id);
		return "redirect:/table/query.action";
	}
}
