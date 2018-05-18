package com.huizhongcf.dubbo.cloud.api.dao;

import java.util.List;

import com.huizhongcf.dubbo.cloud.api.model.User;


public interface UserMapper {
	
	public List<User> find(User user);

}
