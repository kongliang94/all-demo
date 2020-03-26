package com.github.springbootshirodemo.common.util;

import com.github.springbootshirodemo.common.helper.ApiResultHelper;
import com.github.springbootshirodemo.common.model.ApiResultModel;
import com.github.springbootshirodemo.common.model.ResultModel;

/**
 * 返回值工具类
 */
public class ResultUtils {

    public static <S, T> ApiResultModel<S, T> success(S code, String message) {
        return ApiResultHelper.success(code, message, null);
    }


    public static <S, T> ApiResultModel<S, T> success(S code, String message, T data) {
        return ApiResultHelper.success(code, message, data);
    }


    public static <S, T> ApiResultModel<S, T> error(S code, String message) {
        return ApiResultHelper.error(code, message);
    }

    public static ResultModel success() {
        return ApiResultHelper.success(200, "success", null);
    }

    public static <S, T> ApiResultModel<S, T> success(T data) {
        return (ApiResultModel<S, T>) ApiResultHelper.success(200, "success", data);
    }
}
