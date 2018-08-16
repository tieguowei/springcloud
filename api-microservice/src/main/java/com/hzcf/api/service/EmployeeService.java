package com.hzcf.api.service;

import com.hzcf.api.pojo.Employee;

public interface EmployeeService {
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int employeeId);

}
