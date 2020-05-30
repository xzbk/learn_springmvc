package com.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group.entity.User;
/**
 * 根据请求参数限定url
 * @author Administrator
 *
 */
@Controller
public class PartTwoController {
	/**
	 * 注册username，password
	 * @RequestParam注意里面username要和表单参数名一致。一旦用了注解，参数时必须的。除非加一个属性required=false
	 * @return
	 */
	@RequestMapping(value= {"regist"})
	public String one(@RequestParam("username")String username,@RequestParam(value="password",required=false)String password) {
		System.out.println(username+"----"+password);
		return "success";
	}
	/**
	 * 注册username，password
	 * 不打@RequestParam注解，参数可有可无，只需参数名与表单参数明一直即可
	 * @return
	 */
	@RequestMapping(value= {"regist1"})
	public String two(String username,String password) {
		System.out.println(username+"----"+password);
		return "success";
	}
	/**
	 * 支持正则表达式的url
	 * updateUser/100-xiaoming
	 */
	@RequestMapping(value="/updateUser/{userId:\\d+}-{userName:[a-z]+}")
	public String three(@PathVariable("userId") String userId,@PathVariable("userName") String userName){
		
		System.out.println(userId+"-------------------"+userName);
		return "success";
	}
	/**
	 * 封装对象的参数绑定，只需封装对象的属性与表单参数对应即可
	 * @return
	 */
	@RequestMapping("/register2")
	public String four(User user){
		System.out.println(user.getUsername());
		return "success";
	}

	
}
