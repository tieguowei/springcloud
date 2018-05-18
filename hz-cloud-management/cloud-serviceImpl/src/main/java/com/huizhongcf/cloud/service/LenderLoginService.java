/* 
 * Copyright (C) 2014-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: LenderLoginService.java 
 *
 * Created: [2015年9月22日 下午2:31:58] by cheng 
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

package com.huizhongcf.cloud.service;

import java.util.Map;

import com.huizhongcf.cloud.model.LenderLogin;
import com.huizhongcf.util.PageModel;

/** 
 *
 * Description: 查询注册用户
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

public interface LenderLoginService {
	
	/**
	 * 
	 * Description: 分页获取注册用户
	 *
	 * @param map
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年9月22日 下午2:32:29
	 */
	public PageModel findAllByPage(Map<String, Object> map);
	
	/**
	 * 
	 * Description: 加入黑名单
	 *
	 * @param id
	 * @Author lijie
	 * @Create Date: 2016年2月26日 上午11:33:58
	 */
	public void doJoinBlacklist(Integer id);
	
	/**
	 * 
	 * Description: 更新用户
	 *
	 * @param lenderLogin
	 * @return
	 * @Author chengzhichao
	 * @Create Date: 2015年4月28日 下午1:17:44
	 */
	public int updateByPrimaryKeySelective(LenderLogin lenderLogin);
}
