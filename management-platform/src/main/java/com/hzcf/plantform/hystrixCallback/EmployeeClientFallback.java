package com.hzcf.plantform.hystrixCallback;

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
	public void updateEmployeeRole(int employeeId, String rids) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkOldPwd(int employeeId, String oldPwd, String newPs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePwd(int employeeId, String newPwd, String newPs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveEmployee(Employee employee, String newPs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee, String newPs) {
		// TODO Auto-generated method stub
		
	}

	

}
