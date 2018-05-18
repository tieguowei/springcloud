package com.huizhongcf.cloud.dao;

import com.huizhongcf.cloud.model.LenderLogin;

public interface LenderLoginMapper extends BaseMapper<LenderLogin>{
	
	/**
	 * 
	 * Description: 加入黑名单
	 *
	 * @param id
	 * @return
	 * @Author lijie
	 * @Create Date: 2016年2月26日 上午11:34:50
	 */
	Object doJoinBlacklist(Integer id);
	
}