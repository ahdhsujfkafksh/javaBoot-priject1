package com.example.javabootpriject1.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //@Aspect 标记该类为切面，用于实现面向切面编程（AOP）
@Component  //@Component 标记该类为Spring的一个组建让Spring自动将该类注册为bean，可以在应用中使用依赖注入引入
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Pointcut`: 声明该方法为切点；
    `execution`: 切点类型，表示拦截方法执行；
    该切点会拦截 `com.example.javabootpriject1.web` 包中的所有方法，对这些方法进行日志记录等增强操作。*/
    @Pointcut("execution(* com.example.javabootpriject1.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(){
        logger.info("-------doBefore-------");
    }

    @After("log()")
    public void doAfter(){
        logger.info("-------doAfter------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result:{}" + result);
    }
}
