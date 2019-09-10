package com.github.mssql.common.exception;

import java.util.Date;

/**
 * @description: 错误的信息
 * @author: KL
 * @create: 2019-07-19
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
