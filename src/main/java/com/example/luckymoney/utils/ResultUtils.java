package com.example.luckymoney.utils;

import com.example.luckymoney.domain.Result;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-31 11:41
 **/
public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
