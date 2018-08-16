package com.hzcf.plantform.hystrixCallback;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hzcf.plantform.feign.EmployeeFeignClient;
@Component
public class EmployeeClientFallback  implements EmployeeFeignClient {

	@Override
	public Map<String, Object> getEmployeeById(int employeeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "506");
		map.put("message", "请求错误");
		return map;
	}

}
