package com.hzcf.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.api.mapper.EmployeeMapper;
import com.hzcf.api.pojo.Employee;
import com.hzcf.api.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}



}
