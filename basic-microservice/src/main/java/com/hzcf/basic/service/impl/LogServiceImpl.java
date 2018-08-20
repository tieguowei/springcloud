package com.hzcf.basic.service.impl;

import com.hzcf.basic.pojo.Logs;
import com.hzcf.basic.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dt>类名：com.hzcf.basic.service.impl</dt>
 * <dd>描述: 结算单管理</dd>
 * <dd>创建时间：下午 16:23 2018/8/14 0014 </dd>
 * <dd>创建人：朱广伟</dd>
 * <dt>版本历史: </dt>
 * </dl>
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void addLog(Logs logs) {
        mongoTemplate.insert(logs);
    }
}
