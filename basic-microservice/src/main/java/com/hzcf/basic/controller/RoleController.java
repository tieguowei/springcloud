package com.hzcf.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.basic.pojo.Employee;
import com.hzcf.basic.pojo.Role;
import com.hzcf.basic.service.RoleService;
import com.hzcf.basic.util.PageModel;
import com.hzcf.basic.util.ViewTree;
import com.hzcf.util.StringUtil;

/**
 *	角色管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	

	/**
	 * 跳转到角色列表页面
	 * @return
	 */
	@RequestMapping("/goRolePage")
	public String goRolePage(){
		return "roleList";
	}
	
	/**
	 * 分页查询所有角色
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleList")
	public PageModel getRoleList(@RequestParam Map<String, Object> paramsCondition){
		PageModel pageModel = null;
		try {
			  if (!paramsCondition.isEmpty()) {
	    	    	 paramsCondition.put("pageNo",Integer.valueOf((String) paramsCondition.get("pageNo")));
	    	    	 paramsCondition.put("pageSize",Integer.valueOf((String) paramsCondition.get("pageSize")));
				}
			pageModel =roleService.getRoleList(paramsCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}
	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveRole")
	public void saveRole(@RequestBody Role role,@RequestBody Employee employee){
		
			roleService.saveRole(role,employee);
	}
	
	/**ToTo
	 * 校验角色编码是否存在
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkRoleCode")
	public Role checkRoleCode(@RequestParam Map<String, Object> map){
		try {
			if(!map.isEmpty()){
				String roleCode = StringUtil.trim((String)map.get("roleCode"));
				if (StringUtil.isNotBlank(roleCode)) {
					map.put("roleCode", roleCode);
				}
				String id = StringUtil.trim((String)map.get("id"));
				if (StringUtil.isNotBlank(id)) {
					map.put("id", id);
				}
				Role role = roleService.checkRoleCodeIsRepeat(map);
				return role;
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 修改回显
	 */
	
	@ResponseBody
	@RequestMapping("/getRoleById")
	public Role getRoleById(@RequestParam("rid")int id,Model model){
		try {
			Role role=roleService.quertRoleById(id);
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRole")
	public void updateRole(@RequestBody Role role,@RequestBody Employee employee){
			roleService.updateRole(role,employee);
	}
	
	
	/**
	 * 删除菜单
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteRole")
	public void deleteRole(@RequestBody Role role,@RequestBody Employee employee){
			roleService.deleteRole(role,employee);
			
	}
	
	/**
	 * 加载权限菜单
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/viewTree")
	public List<ViewTree> getRoleTree(@RequestParam("rid")int rid){
		try {
			return roleService.getViewTree(rid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改角色权限
	 */
	
	@ResponseBody
	@RequestMapping("/updateRoleAuth")
	public void updateRoleAuth(@RequestParam("rid")int rid,@RequestParam("menuIds")String menuIds,@RequestBody Employee employee){
				roleService.updateRoleAuth(rid, menuIds,employee);
	}
	
}
