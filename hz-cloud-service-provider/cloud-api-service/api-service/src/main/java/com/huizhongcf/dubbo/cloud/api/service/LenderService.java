package com.huizhongcf.dubbo.cloud.api.service;

import java.util.List;

import com.huizhongcf.dubbo.cloud.api.model.User;

public interface LenderService {
	
	public List<User> find(User user);

}
