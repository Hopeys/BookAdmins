package com.ysq.obooks.common;

/**
 *   统一异常
 */
public class BookAdminException extends RuntimeException {

    private final Integer code;
    private final String message;

    public BookAdminException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BookAdminException(BookAdminExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
