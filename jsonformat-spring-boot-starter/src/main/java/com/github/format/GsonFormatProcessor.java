package com.github.format;


import com.google.gson.Gson;

public class GsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        Gson gson= new Gson();
        return "gson:"+gson.toJson(obj);
    }
}
