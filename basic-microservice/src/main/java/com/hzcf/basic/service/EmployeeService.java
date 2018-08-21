package com.hzcf.basic.service;

import java.util.List;
import java.util.Map;

import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.pojo.Role;
import com.hzcf.basic.util.PageModel;

public interface EmployeeService {
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int employeeId);
	/**
	 * 校验员工原始密码是否正确
	 * @return
	 */
	boolean checkOldPwd(int employeeId, String oldPwd,String newPs);
	/**
	 * 修改员工密码
	 * @return
	 */
	void updatePwd(int employeeId, String newPwd,String newPs);
	/**
	 * 查询所有员工
	 * @param paramsCondition
	 * @return
	 */
	PageModel getEmployeeList(Map<String, Object> paramsCondition);
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> getRoleList();

	/**查询员工所属角色
	 */
	List<Integer> getRoleByEmployeeId(int employeeId);
	/**
	 * 修改员工角色
	 * @param merchantId
	 * @param rids
	 */
	void updateEmployeeRole(int employeeId, String rids);
	/**
	 * 添加员工
	 * @param employee
	 */
	void saveEmployee(Employee employee,String newPs);
	
	/**
	 * 修改员工
	 */
	void updateEmployee(Employee employee,String newPs);
	/**
	 * 删除员工
	 * @param employee
	 */
	void deleteEmployee(Employee employee);
	
}
