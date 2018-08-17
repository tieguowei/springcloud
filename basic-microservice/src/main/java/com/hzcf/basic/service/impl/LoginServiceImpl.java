package com.hzcf.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.basic.mapper.EmployeeMapper;
import com.hzcf.basic.mapper.MenuMapper;
import com.hzcf.basic.mapper.RoleMapper;
import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.pojo.Menu;
import com.hzcf.basic.pojo.Role;
import com.hzcf.basic.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private EmployeeMapper  employeeMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	

	
	protected final Log logger = LogFactory.getLog(getClass());
	

	
	@Override
	public Employee getEmployeeByEmployeeNo(String employeeNo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("employeeNo", employeeNo);
		Employee employee = employeeMapper.getEmployeeByEmployeeNo(map);
		return employee;
	}
	


	/**
	 * 根据商户ID查询角色信息
	 */
	@Override
	public List<Role> findRoleByEmployeeId(Integer id) {
		return roleMapper.findRoleByEmployeeId(id);
	}


	/**
	 * 根据商户角色id 查询权限
	 */
	@Override
	public List<Menu> permissionListRoleId(Integer id) {
		return menuMapper.permissionListRoleId(id);
	}




	

	
}
