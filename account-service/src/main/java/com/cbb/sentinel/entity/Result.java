package com.cbb.sentinel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chengbb
 * @date 2020.7.24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    private static final Integer SUCCESS_CODE = 1;
    private Integer code = 1;
    private String message;
    private T data;

    public static <T> Result getSuccessResult(T content, String msg) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage(msg);
        result.setData(content);
        return result;
    }

    public static Result getSuccessResult() {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("success");
        return result;
    }

    public static <T> Result getSuccessResult(T content) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage("success");
        result.setData(content);
        return result;
    }

    public static Result getFailResult(String message) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage(message);
        return result;
    }

    public static Result getFailResult(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result getFailResult(Integer code, String message, T content) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(content);
        return result;
    }


    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

}
