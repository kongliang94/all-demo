package com.github.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;

public class JacksonFormatProcessor implements FormatProcessor{

    Logger logger=Logger.getLogger("JacksonFormatProcessor");
    @Override
    public <T> String format(T obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info("===========jackson format===========");
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
