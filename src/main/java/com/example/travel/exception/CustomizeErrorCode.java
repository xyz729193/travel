package com.example.travel.exception;
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("你找的问题不存在了，请换一个试试吧");
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
