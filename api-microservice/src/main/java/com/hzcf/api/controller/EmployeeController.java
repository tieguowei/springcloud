package com.hzcf.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.api.pojo.Employee;
import com.hzcf.api.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 *<dl>
 *<dt>类名：EmployeeController.java</dt>
 *<dd>描述:员工逻辑实现</dd> 
 *<dd>创建时间： 2018年8月6日 下午5:33:38</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 *
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月6日 下午5:33:38    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@Api(value="员工controller",tags={"员工操作接口"})
@RestController
public class  EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	 
	
	
	/**
	 * 修改员工 回显
	 * @return
	 */
    @ApiOperation(value="获取员工信息")
	@GetMapping("/getEmployeeById/{employeeId}")
	@ResponseBody
	public Map<String,Object> getEmployeeById(@PathVariable int employeeId){
		try {
			System.out.println("=======66666666666==========");
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
