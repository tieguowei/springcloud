package com.hzcf.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.user.mapper.EmployeeMapper;
import com.hzcf.user.pojo.Employee;
import com.hzcf.user.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}



}
