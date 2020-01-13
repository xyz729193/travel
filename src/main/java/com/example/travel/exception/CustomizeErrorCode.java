package com.example.travel.exception;
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001,"你找的问题不存在了，请换一个试试吧"),
    TARGET_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"您还未登录，请登录后重新尝试～"),
    SYS_ERROR(2004,"服务器冒烟了，请稍后再试～"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，要不然换一个试试？！");



    private Integer code;
    private String message;
    @Override
    public String getMessage() {
        return message;
    }
    public Integer getCode(){ return code;}

    CustomizeErrorCode( Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}
