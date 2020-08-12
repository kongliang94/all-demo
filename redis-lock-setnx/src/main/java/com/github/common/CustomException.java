package com.github.common;

public class CustomException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }

    public CustomException(Throwable throwable) {
        super(throwable);
    }
}
