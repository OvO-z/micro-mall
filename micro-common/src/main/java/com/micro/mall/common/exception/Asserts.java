package com.micro.mall.common.exception;

import com.micro.mall.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出API异常
 * @author QAQ
 * @date 2021/5/24
 */

public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
