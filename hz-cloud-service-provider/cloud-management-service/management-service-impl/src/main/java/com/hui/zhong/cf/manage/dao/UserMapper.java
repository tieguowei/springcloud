package com.hui.zhong.cf.manage.dao;

import java.util.List;

import com.hui.zhong.cf.manage.model.User;



public interface UserMapper {
	
	public List<User> find(User user);

}
