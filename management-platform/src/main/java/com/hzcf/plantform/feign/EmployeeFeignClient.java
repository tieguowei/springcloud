package com.hzcf.plantform.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hzcf.plantform.hystrixCallback.EmployeeClientFallback;

/**
 *<dl>
 *<dt>类名：EmployeeFeignClient.java</dt>
 *<dd>描述: 员工管理逻辑实现</dd> 
 *<dd>创建时间： 2018年8月13日 下午5:21:53</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月13日 下午5:21:53    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@FeignClient(name = "basic-microservice", fallback =EmployeeClientFallback.class)
public interface  EmployeeFeignClient {

	  //getEmployeeById方法是服务提供者中的方法
	  @RequestMapping(value = "/getEmployeeById/{employeeId}", method = RequestMethod.GET)
	  public  Map<String,Object> getEmployeeById(@PathVariable("employeeId") int employeeId);
	  
}
