package com.example.luckymoney.domain;

import lombok.Data;

/**
 * @program: luckymoney
 * @description: 返回结果
 * @author: 张清
 * @create: 2019-12-31 11:07
 **/
@Data
public class Result<T> {
    /* 错误码 */
    private Integer code;

    /* 提示信息 */
    private String msg;

    /* 返回具体内容 */
    private T data;
}
