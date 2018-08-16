package com.hzcf.user.service;

import com.hzcf.user.pojo.Employee;

public interface EmployeeService {
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int employeeId);

}
