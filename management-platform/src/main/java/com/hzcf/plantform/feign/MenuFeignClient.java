package com.hzcf.plantform.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hzcf.plantform.pojo.Menu;


/**
 *<dl>
 *<dt>类名：MenuFeignClient.java</dt>
 *<dd>描述: 菜单管理FeignClient</dd> 
 *<dd>创建时间： 2018年8月13日 下午2:10:37</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月13日 下午2:10:37    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@FeignClient(name = "basic-microservice", fallback =FeignDisableHystrixConfiguration.class)
public interface  MenuFeignClient {

	
	  /**
		 * 根据员工id获取菜单
		 * getMenuByEmployeeId是服务提供者中的方法名
		 * @param id
		 * @return
		 */
	  @RequestMapping(value = "/menu/getMenuByEmployeeId/{employeeId}", method = RequestMethod.POST)
	  public List<Menu> getMenuByEmployeeId(@PathVariable("employeeId") int employeeId);

	/*  public PageModel getMenuList(Map<String, Object> paramsCondition);*/
	  
}
