package com.lwc.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -3901030351204236351L;

    private Integer code;
    private T data;
    private String message;

    public Result(CodeEnum code, T data, String message) {
        this.code = code.getCode();
        this.data = data;
        this.message = message;
    }

    public static<T> Result SUCCESS(){
        return SUCCESS(CodeEnum.SUCCESS, null, CodeEnum.SUCCESS.getMessage());
    }

    public static<T> Result SUCCESS(T data){
        return SUCCESS(CodeEnum.SUCCESS, data, CodeEnum.SUCCESS.getMessage());
    }

    public static<T> Result SUCCESS(T data, String message){
        return SUCCESS(CodeEnum.SUCCESS, data, message);
    }

    public static<T> Result SUCCESS(CodeEnum code, T data, String message){
        return new Result(code, data, message);
    }

    public static<T> Result FAILED(){
        return FAILED(CodeEnum.FAILED, null, CodeEnum.FAILED.getMessage());
    }

    public static<T> Result FAILED(String message){
        return FAILED(CodeEnum.FAILED, null, message);
    }

    public static<T> Result FAILED(CodeEnum code, String message){
        return FAILED(code, null, message);
    }

    public static<T> Result FAILED(CodeEnum code, T data, String message){
        return new Result(code, data, message);
    }

}
