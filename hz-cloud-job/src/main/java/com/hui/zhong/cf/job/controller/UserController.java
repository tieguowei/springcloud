package com.hui.zhong.cf.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hui.zhong.cf.manage.model.User;
import com.hui.zhong.cf.manage.service.LenderService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private LenderService lenderService;
	
	@RequestMapping("/find")
	@ResponseBody
	public Object find(){
		
		User user = new User();
		user.setUserid(1);
		return lenderService.find(user);
	}

}
