package com.hzcf.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzcf.basic.pojo.Menu;
import com.hzcf.basic.service.MenuService;


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
	  
        /*   @RequestMapping("/getMenuList")
            public Map getMenuList(@RequestBody HttpServletRequest request ) {
        	try {
        	    Map<String, Object> paramsCondition = new HashMap<String, Object>();
        	    String nameZh = StringUtil.trim(request.getParameter("nameZh"));
        	    if (StringUtil.isNotBlank(nameZh)) {
        		paramsCondition.put("nameZh", nameZh);
        	    }
        	    paramsCondition.put("pageNo",
        		    Integer.valueOf(request.getParameter("pageNumber")));
        	    paramsCondition.put("pageSize",
        		    Integer.valueOf(request.getParameter("pageSize")));
        	    PageModel pageModel = menuService.getMenuList(paramsCondition);
        	    dataMsg.setTotal(pageModel.getTotalRecords());
        	    dataMsg.setRows(pageModel.getList());
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
        	return dataMsg;
            }
        	  */
	
}
