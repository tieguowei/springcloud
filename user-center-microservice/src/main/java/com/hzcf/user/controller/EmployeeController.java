package com.hzcf.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.user.pojo.Employee;
import com.hzcf.user.service.EmployeeService;



@RestController
public class  EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	 
	
	
	/**
	 * 修改员工 回显
	 * @return
	 */
	@GetMapping("/getEmployeeById/{employeeId}")
	@ResponseBody
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
