package com.github.format;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = FormatProperties.FORMAT_TYPE_PREFIX)
public class FormatProperties {
    public final static String FORMAT_TYPE_PREFIX="json.format";

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
