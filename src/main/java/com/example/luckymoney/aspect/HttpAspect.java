package com.example.luckymoney.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: luckymoney
 * @description: AOP编程切面类
 * @author: 张清
 * @create: 2019-12-31 11:00
 **/
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.example.luckymoney.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("\n");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }


    /**
     * 异常处理
     * */
    @Pointcut("execution(public * com.example.luckymoney.handle.*.*(..))")
    public void errorLog() {
    }

    @Before("errorLog()")
    public void doErrorBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.error("url={}", request.getRequestURL());
        //method
        logger.error("method={}", request.getMethod());
        //ip
        logger.error("ip={}", request.getRemoteAddr());
        //类方法
        logger.error("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.error("args={}", joinPoint.getArgs());
    }

    @After("errorLog()")
    public void doErrorAfter() {
        logger.error("程序执行完毕");
    }

    @AfterReturning(returning = "object", pointcut = "errorLog()")
    public void doErrorAfterReturning(Object object) {
        logger.error("response={}", object.toString());
        logger.error("\n");
    }
}
