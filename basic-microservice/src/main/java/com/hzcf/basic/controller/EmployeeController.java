package com.hzcf.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.service.EmployeeService;


@RequestMapping("/employee")
@RestController
public class  EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	 
	
	
	/**
	 * 修改员工 回显
	 * @return
	 */
	@RequestMapping("/getEmployeeById/{employeeId}")
	public Map<String,Object> getEmployeeById(@PathVariable int employeeId){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			 Employee employee = employeeService.getEmployeeById(employeeId);
			 map.put("employee", employee);
			 return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
