package com.hui.zhong.cf.job.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hui.zhong.cf.manage.model.User;
import com.hui.zhong.cf.manage.service.LenderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-base.xml"})
public class TestDubboService {

	@Autowired
	private LenderService lenderService;
	@Test
	public void testUser(){
		User user = new User();
		user.setUserid(1);
		List<User> find = lenderService.find(user);
		System.out.println(find);
	}
	
}
