package com.jijuwuhua.myblog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ：chenjiajun
 * @description：页面丢失异常处理
 * @date ：2021/3/10 15:16
 */
//继承RuntimeException，方便于运行时捕获
//指定该异常抛出的返回状态码,即使其明确要返回到404页面
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindException extends RuntimeException{
    public NotFindException() {
    }

    public NotFindException(String message) {
        super(message);
    }

    public NotFindException(String message, Throwable cause) {
        super(message, cause);
    }
}
