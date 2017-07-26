package com.systec.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wh on 7/12/2017.
 */

@RestController
@RequestMapping(value = "redis")
public class StringRedisController {

    protected static Logger logger = LoggerFactory.getLogger(StringRedisController.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOpsStr;

    @RequestMapping(value = "/set")
    private String setKeyAndValue(String key, String value){
        logger.debug("set key and value");
        valueOpsStr.set(key, value);
        return "set OK";
    }

    @RequestMapping(value = "/get")
    private String getKey(String key){
        logger.debug("get value by key");
        valueOpsStr.get(key);
        return "get Ok";
    }
}
