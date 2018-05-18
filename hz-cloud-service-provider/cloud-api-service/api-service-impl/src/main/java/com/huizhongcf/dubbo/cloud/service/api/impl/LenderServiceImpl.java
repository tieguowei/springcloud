package com.huizhongcf.dubbo.cloud.service.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhongcf.dubbo.cloud.api.dao.UserMapper;
import com.huizhongcf.dubbo.cloud.api.model.User;
import com.huizhongcf.dubbo.cloud.api.service.LenderService;

@Service
public class LenderServiceImpl implements LenderService {
	
	@Autowired 
	private UserMapper userMapper;
	
	public List<User> find(User user){
		return userMapper.find(user);
	}
	
	

}
