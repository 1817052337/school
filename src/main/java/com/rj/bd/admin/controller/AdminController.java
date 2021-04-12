package com.rj.bd.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
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

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public String login(String account) {
        Admin admin = AdminService.login(account);
        DTO dto = new DTO();
        if (admin == null) {
            dto.code = "-1";
            dto.msg = "没有该用户";
        } else {
            //把用户登录信息放进Session
            Map<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("a_id", admin.getA_id());
            String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
            dto.data = sessionId;
        }
        return JSON.toJSONString(admin);
    }
}
