package com.hzcf.basic.service;

import com.hzcf.basic.pojo.Employee;

public interface EmployeeService {
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int employeeId);

}
