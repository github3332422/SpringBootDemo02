package com.example.luckymoney.enums;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-31 17:09
 **/

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"太少了"),
    MIDDLE_SCHOOL(101,"还行吧"),


    ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
