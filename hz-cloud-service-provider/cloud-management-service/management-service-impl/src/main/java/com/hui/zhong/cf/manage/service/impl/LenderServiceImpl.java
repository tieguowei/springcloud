package com.hui.zhong.cf.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hui.zhong.cf.manage.dao.UserMapper;
import com.hui.zhong.cf.manage.model.User;
import com.hui.zhong.cf.manage.service.LenderService;

@Service
public class LenderServiceImpl implements LenderService {
	
	@Autowired 
	private UserMapper userMapper;
	
	public List<User> find(User user){
		return userMapper.find(user);
	}
	
	

}
