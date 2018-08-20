package com.hzcf.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.basic.pojo.Menu;
import com.hzcf.basic.service.MenuService;
import com.hzcf.basic.util.PageModel;
import com.hzcf.util.StringUtil;


@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	   /**
	   * 通过员工id查询菜单
	   * @param employeeId
	   * @return
	   */
	  @RequestMapping("/getMenuByEmployeeId/{employeeId}")
	  public List<Menu> getEmployeeById(@PathVariable int employeeId) {
		  return menuService.getMenuByEmployeeId(employeeId);
	  }
	  
	  /**
		 * 分页查询所有
		 * @param pageNumber
		 * @param pageSize
		 * @return
		 */
		@RequestMapping("/getMenuList")
		public PageModel getMenuList(@RequestParam Map<String, Object> paramsCondition ) {
			PageModel pageModel = null;
			try {
		    	    String nameZh = null;
		    	    if (!paramsCondition.isEmpty()) {
		    	    	nameZh = StringUtil.trim((String)(paramsCondition.get("nameZh")));
		    	    	 paramsCondition.put("pageNo",Integer.valueOf((String) paramsCondition.get("pageNo")));
		    	    	 paramsCondition.put("pageSize",Integer.valueOf((String) paramsCondition.get("pageSize")));
					}
		    	    
		    	    if (StringUtil.isNotBlank(nameZh)) {
		    		paramsCondition.put("nameZh", nameZh);
		    	    }
		    	   
		    	    pageModel = menuService.getMenuList(paramsCondition);
			} catch (Exception e) {
			    e.printStackTrace();
			}
				return pageModel;
		}
		
		/**
		 * 查询所有pid为0的菜单
		 * @return map
		 */
		@RequestMapping("/getParentMenuList")
		public List<Map<String,Object>> getParentMenuList(){
				return menuService.getParentMenuList();
		}
	        
		/**
		 * 添加菜单
		 * @param menu
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/saveMenu")
		public void saveMenu(@RequestBody Menu menu,@RequestParam("employeeId") int employeeId){
				menuService.saveMenu(menu,employeeId);
		}
		
		/**ToTo
		 * 校验菜单名称是否存在
		 * @param menu   
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/checkMenuName")
		public Menu checkMenuName(@RequestParam Map<String, Object> map){
			
				String nameZh = StringUtil.trim((String)map.get("nameZh"));
				if (StringUtil.isNotBlank(nameZh)) {
					map.put("nameZh", nameZh);
				}
				
				String menuId = StringUtil.trim((String)map.get("menuId"));
				if (StringUtil.isNotBlank(menuId)) {
					map.put("menuId", menuId);
				}
				Menu menu = menuService.checkMenuNameIsRepeat(map);
				return menu;
		}
		
		/**ToTo
		 * 修改回显
		 */
		@ResponseBody
		@RequestMapping("/getMenuById")
		public Menu getMenuById(@RequestParam("mid")int mid){
			try {
				Menu menu=menuService.quertMenuById(mid);
				return menu;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/**ToTo
		 * 修改菜单
		 * @param menu
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/updateMenu")
		public void updateMenu(@RequestBody Menu menu,@RequestParam("employeeId") int employeeId){
				menuService.updateMenu(menu,employeeId);
		}
		
		/**
		 * 删除菜单
		 * @param menu
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/deleteMenu")
		public void deleteMenu(@RequestBody Menu menu,@RequestParam("employeeId") int employeeId){
			
				menuService.deleteMenu(menu,employeeId);
		}
	
}
