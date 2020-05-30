package com.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * url和请求方法限定
 * @author Administrator
 *
 */
@Controller
public class PartOneController {
	/**
	 * 一个方法匹配多个路径
	 * @return
	 */
	@RequestMapping(value= {"/multi1","/multi2","/multi3"})
	public String one() {
		return "success";
	}
	/**
	 * 匹配通配符 /user/ssssss/addUser
	 * @return
	 */
	@RequestMapping("/user/*/addUser")
	public String two() {
		return "success";
	}
	/**
	 * Ant风格映射,匹配通配符 /user/sss/aa/sss/addUser
	 * @return
	 */
	@RequestMapping("/user/**/addUser")
	public String three() {
		return "success";
	}

	/**
	 * URL模板映射
	 * /user/1, {userId}表示接受一个用户的id
	 * @return
	 */
	@RequestMapping("/user/{userId}")
	public String four(@PathVariable("userId")int userId) {
		System.out.println("获取到的是："+userId);
		return "success";
	}
	/**
	 * 通过请求方式来区分请求的不同
	 * @return
	 */
	@RequestMapping(value="/user/add",method=RequestMethod.GET)
	public String five() {
		System.out.println("get");
		return "success";
	}
	/**
	 * 通过请求方式区分请求的不同
	 * @return
	 */
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public String six() {
		System.out.println("post");
		return "success";
	}
}
