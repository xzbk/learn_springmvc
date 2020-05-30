package com.group.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.entity.User;
/**
 * 根据请求参数绑定
 * @author Administrator
 *
 */
@Controller
public class PartThreeController {
	/**
	 * 如何绑定请求参数,加上modelattribute注解会将user放到request作用域。
	 * 相当于request.setAttribute("user",user)
	 * @return
	 */
	@RequestMapping("/register3")
	public String register3(@ModelAttribute("user")User user){
		System.out.println(user);
		return "success";
	}
	/**
	 * 获取request内容，读取为输入流的形式(提交表单用post方式)
	 */
	@RequestMapping(value="/reqBody")
	public String reqBody(@RequestBody String rbody) throws IOException{
		System.out.println(rbody);
		return "success";
	}
	/**
	 * 将对象转换为json串格式返回
	 */
	@ResponseBody
	@RequestMapping(value="/rpnBody")
	public List<User> rpnBody() throws IOException{
		 List<User> users=new ArrayList<>();
		 User user=new  User();		 
		 user.setUsername("张三");
		 user.setPassword("ok");
		 User user1=new  User();		 
		 user1.setUsername("李四");
		 user1.setPassword("ok");
		 users.add(user);
		 users.add(user1);
		 return users;
	}

}
