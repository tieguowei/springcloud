package com.hzcf.plantform.hystrixCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hzcf.plantform.feign.EmployeeFeignClient;
import com.hzcf.plantform.pojo.Employee;
import com.hzcf.plantform.pojo.Role;
import com.hzcf.plantform.util.PageModel;
@Component
public class EmployeeClientFallback  implements EmployeeFeignClient {

	@Override
	public Employee getEmployeeById(int employeeId) {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("code", "506");
//		map.put("message", "请求错误");
		return null;
	}

	@Override
	public PageModel getEmployeeList(Map<String, Object> paramsCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getRoleByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkOldPwd(int employeeId, String oldPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePwd(int employeeId, String newPwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployeeRole(int employeeId, String rids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	

}
