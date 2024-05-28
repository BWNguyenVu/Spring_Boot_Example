package com.example.crud.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude if null, don't show
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private int code = 200;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
