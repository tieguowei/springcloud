package com.hzcf.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.basic.mapper.EmployeeMapper;
import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}



}
