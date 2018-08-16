package com.hzcf.basic.controller;

import com.hzcf.basic.pojo.Logs;
import com.hzcf.basic.service.LogService;
import com.hzcf.basic.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>类名：com.hzcf.basic.controller</dt>
 * <dd>描述: 结算单管理</dd>
 * <dd>创建时间：下午 15:49 2018/8/14 0014 </dd>
 * <dd>创建人：朱广伟</dd>
 * <dt>版本历史: </dt>
 * </dl>
 */
@RequestMapping("log")
@RestController
public class LogController {

    @Autowired
    LogService logService;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "addLog", method = RequestMethod.GET)
    public Map<String, Object> addLog() {
        Map<String, Object> resMap = new HashMap<>();
        Logs logs = new Logs();
        logs.setText("测试日志插入");
        logService.addLog(logs);
        return resMap;
    }

    @RequestMapping(value = "testRedis", method = RequestMethod.GET)
    public Map<String, Object> testRedis() {
        Map<String, Object> resMap = new HashMap<>();
        boolean flag = redisUtil.set("testzgw","testzgw");
        resMap.put("flag", flag);

        if(flag){
            resMap.put("value",redisUtil.get("testzgw"));
            resMap.put("isEqual", redisUtil.get("testzgw").equals("testzgw"));
        }
        return resMap;
    }
}
