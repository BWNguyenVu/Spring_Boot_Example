package com.example.crud.exeptions;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(1, "Uncategorized Exception"),
    USER_EXISTED(400, "User existed"),
    USERNAME_INVALID(400, "User name must be at least 3 characters"),
    PASSWORD_INVALID(400, "Password must be at least 8 characters")
    ;


    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
