package com.example.luckymoney.exception;

import com.example.luckymoney.enums.ResultEnum;
import lombok.Data;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-31 16:38
 **/
// Spring 对只有是 RuntimeException 的异常进行回滚
@Data
public class MyException extends RuntimeException {
    private Integer code;
    public MyException (Integer code,String message){
        super(message);
        this.code = code;
    }
    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
