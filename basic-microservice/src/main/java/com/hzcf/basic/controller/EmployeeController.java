package com.hzcf.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.pojo.Role;
import com.hzcf.basic.service.EmployeeService;
import com.hzcf.basic.util.PageModel;
import com.hzcf.util.StringUtil;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 修改员工 回显
	 * 
	 * @return
	 */
	@RequestMapping("/getEmployeeById")
	public Employee getEmployeeById(@RequestParam("employeeId") int employeeId) {
		try {

			Employee employee = employeeService.getEmployeeById(employeeId);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 分页查询所有员工
	 * 
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEmployeeList")
	public PageModel getEmployeeList(@RequestParam Map<String, Object> paramsCondition) {
		PageModel pageModel = null;
		try {
			if (!paramsCondition.isEmpty()) {
				String employeeNo = StringUtil.trim((String) paramsCondition.get("employeeNo"));
				if (StringUtil.isNotBlank(employeeNo)) {
					paramsCondition.put("employeeNo", employeeNo);
				} else if (!"admin".equals(paramsCondition.get("employeeNo"))) {

					paramsCondition.put("employeeNo", paramsCondition.get("employeeNo"));
				}
				String employeeName = StringUtil.trim((String) paramsCondition.get("employeeName"));
				if (StringUtil.isNotBlank(employeeName)) {
					paramsCondition.put("employeeName", employeeName);
				}
				paramsCondition.put("pageNo", Integer.valueOf((String) paramsCondition.get("pageNo")));
				paramsCondition.put("pageSize", Integer.valueOf((String) paramsCondition.get("pageSize")));
			}
			pageModel = employeeService.getEmployeeList(paramsCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	/**
	 * 查询员工拥有的角色
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRole")
	public List<Role> getRoleList() {
		List<Role> rlist = employeeService.getRoleList();
		return rlist;
	}

	/**
	 * 查询员工拥有的角色
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleList")
	public List<Integer> getRoleByEmployeeId(@RequestParam("employeeId") int employeeId) {
		List<Integer> employeeRoleList = employeeService.getRoleByEmployeeId(employeeId);
		return employeeRoleList;
	}

	/**
	 * 校验商户原始密码是否正确
	 * 
	 * @return
	 */
	@RequestMapping("/checkOldPwd")
	@ResponseBody
	public boolean checkOldPwd(@RequestParam("employeeId") int employeeId, @RequestParam("oldPwd") String oldPwd) {
		return employeeService.checkOldPwd(employeeId, oldPwd);
	}

	/**
	 * 修改用户密码
	 * 
	 * @return
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public void updatePwd(@RequestParam("employeeId") int employeeId, @RequestParam("newPwd") String newPwd) {
		employeeService.updatePwd(employeeId, newPwd);

	}

	/**
	 * 修改员工角色
	 * 
	 * @param EmployeeRole
	 * @param rids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateEmployeeRole")
	public void updateEmployeeRole(@RequestParam("employeeId") int employeeId, @RequestParam("rid") String rids) {

		employeeService.updateEmployeeRole(employeeId, rids);
	}

	/**
	 * 添加员工
	 * 
	 * @return
	 */
	@RequestMapping("/saveEmployee")
	@ResponseBody
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);

	}

	/**
	 * 修改员工信息
	 * 
	 * @return
	 */
	@RequestMapping("/updateEmployee")
	@ResponseBody
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

	/**
	 * 删除员工
	 * @param merchant
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteEmployee")
	public void deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);

	}
}
