package com.github.format;

import com.alibaba.fastjson.JSON;

public class FastjsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "fastjson:"+JSON.toJSONString(obj);
    }
}
