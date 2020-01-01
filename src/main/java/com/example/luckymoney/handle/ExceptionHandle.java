package com.example.luckymoney.handle;

import com.example.luckymoney.domain.Result;
import com.example.luckymoney.exception.MyException;
import com.example.luckymoney.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtils.error(myException.getCode(),myException.getMessage());
        }else{
            logger.error("[系统异常]");
            return ResultUtils.error(-1,"未知错误");
        }
    }
}
