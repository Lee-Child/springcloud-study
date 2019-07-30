package com.lwc.common;

import lombok.Data;

public enum  CodeEnum {

    SUCCESS(1000, "成功"),
    FAILED(2000, "失败");

    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
