package com.hzcf.basic.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.pojo.Menu;
import com.hzcf.basic.pojo.Role;
import com.hzcf.basic.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	   * 根据员工ID查询角色信息
	   * @param employeeId
	   * @return
	   */
	 @RequestMapping("/findRoleByEmployeeId/{employeeId}")
	  public List<Role> findRoleByEmployeeId(@PathVariable int employeeId) {
		  return loginService.findRoleByEmployeeId(employeeId);
	  }
	  
	  /**
	   * 根据员工角色id 查询权限
	   * @param employeeId
	   * @return
	   */
	  @RequestMapping("/permissionListRoleId/{employeeId}")
	  public List<Menu> permissionListRoleId(@PathVariable int employeeId) {
		  return loginService.permissionListRoleId(employeeId);
	  }
	  
	  
	  /**
	   * 通过员工编号查询员工信息
	   * @param employeeId
	   * @return
	   */
	  @RequestMapping("/getEmployeeByEmployeeNo/{employeeNo}")
	  public Employee getEmployeeByEmployeeNo(@PathVariable String employeeNo) {
		  return loginService.getEmployeeByEmployeeNo(employeeNo);
	  }
	  
	 
}
