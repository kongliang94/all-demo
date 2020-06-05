package com.github.format;

import com.alibaba.fastjson.JSON;

import java.util.logging.Logger;

public class FastjsonFormatProcessor implements FormatProcessor{

    Logger logger=Logger.getLogger("FastjsonFormatProcessor");
    @Override
    public <T> String format(T obj) {
        logger.info("===========fast-json format===========");
        return JSON.toJSONString(obj);
    }
}
