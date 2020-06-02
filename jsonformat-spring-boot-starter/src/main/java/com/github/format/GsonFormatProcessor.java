package com.github.format;


import com.google.gson.Gson;

import java.util.logging.Logger;

public class GsonFormatProcessor implements FormatProcessor{
    Logger logger=Logger.getLogger("GsonFormatProcessor");
    @Override
    public <T> String format(T obj) {
        Gson gson= new Gson();
        logger.info("===========gson format===========");
        return gson.toJson(obj);
    }
}
