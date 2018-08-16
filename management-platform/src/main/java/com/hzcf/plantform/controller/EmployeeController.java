package com.hzcf.plantform.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.plantform.feign.EmployeeFeignClient;


/**
 *<dl>
 *<dt>类名：EmployeeController.java</dt>
 *<dd>描述:员工管理逻辑实现</dd> 
 *<dd>创建时间： 2018年8月6日 下午5:33:38</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月6日 下午5:33:38    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@Controller
@RequestMapping("/employee")
public class  EmployeeController {

	  @Autowired
	  private EmployeeFeignClient employeeFeignClient;
	  
	  
	  /**
	   * 通过员工编号查询员工信息
	   * @param employeeId
	   * @return
	   */
	  @RequestMapping("/getEmployeeById/{employeeId}")
	  @ResponseBody
	  public Map<String,Object> getEmployeeById(int employeeId) {
		  return employeeFeignClient.getEmployeeById(employeeId);
	  }

	   /**
		 * 跳转到员工列表页面
		 * @return
		 */
		//@RequiresPermissions("employeeManager:list")//权限管理;
		@RequestMapping("/goEmployeePage")
		public String goEmployeePage(){
			return "employeeList";
		}
}
