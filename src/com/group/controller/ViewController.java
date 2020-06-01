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
 * 视图部分
 * @author Administrator
 *
 */
@Controller
public class ViewController {
	/**
	 * 请求跳转(默认为此)
	 * @return
	 */
	@RequestMapping("/forward")
	public String forward(){
		return "forward:/success.jsp";
	}
	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping("/redirect")
	public String redirect(){
		return "redirect:/success.jsp";
	}
}
