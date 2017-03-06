package com.mvp.com.mvp.model;

/**
 * Created by ankit on 7/2/17.
 * Represents the status for the whether or not the Api call is successful or not
 *
 */
public class Status {
    private int code;
    private String message;

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

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

    @Override
    public String toString() {
        return "Status{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * Helper method to get the presentable
     */
    public String getErrorMsg() {
        return "Error occurred with code ->" + code +
                "and msg ->" + message;
    }
}
