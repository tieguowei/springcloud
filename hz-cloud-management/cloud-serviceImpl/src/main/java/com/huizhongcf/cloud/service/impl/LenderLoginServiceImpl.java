/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderLoginServiceImpl.java 
 *
 * Created: [2015年9月22日 下午2:33:16] by cheng 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: ephwealth-admin 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.huizhongcf.cloud.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhongcf.cloud.dao.LenderLoginMapper;
import com.huizhongcf.cloud.model.LenderLogin;
import com.huizhongcf.cloud.service.LenderLoginService;
import com.huizhongcf.util.PageModel;

/** 
 *
 * Description: 注册用户查询
 *
 * @author chengzhichao 
 * @version 1.0
 * <pre>
 * Modification History: 
 *  Date           Author        Version       Description 
 * ------------------------------------------------------------------ 
 * 2015年9月22日      chengzhichao       1.0         1.0 Version 
 * </pre>
 */
@Service
public class LenderLoginServiceImpl implements LenderLoginService {

	@Autowired
	private LenderLoginMapper lenderLoginMapper;
	
	@Override
	public PageModel findAllByPage(Map<String, Object> map) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) map.get("pageNo"));
		pageModel.setPageSize((Integer) map.get("pageSize"));
		map.put("startIndex", pageModel.getStartIndex());
		map.put("endIndex", pageModel.getEndIndex());
		List<Map<String,Object>> list = lenderLoginMapper.findAllRetMapByPage(map);
		Long totalRecords = lenderLoginMapper.findAllByPageCount(map);
		pageModel.setList(list);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public void doJoinBlacklist(Integer id) {
		lenderLoginMapper.doJoinBlacklist(id);
	}
	
	@Override
	public int updateByPrimaryKeySelective(LenderLogin lenderLogin) {
		return lenderLoginMapper.updateByPrimaryKeySelective(lenderLogin);
	}

}
