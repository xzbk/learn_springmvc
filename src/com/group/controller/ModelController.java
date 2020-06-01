package com.group.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.entity.User;
/**
 * 模型部分
 * @author Administrator
 *
 */
@Controller
public class ModelController {
	/**
	 * 3.通过ModelMap接口放入model对象
	 * 
	 */
	@RequestMapping("/model1")
	public String model1(Model model,Map map,ModelMap mm){
		map.put("username", "王五");
		return "model";
	}
	/**
	 * 将数据放到request,session
	 */
	@RequestMapping("/model2")
	public String model2(HttpServletRequest request,HttpSession se){
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("ok");
		request.setAttribute("user", user);
		se.setAttribute("user", user);
		return "model";
		
	}
}
