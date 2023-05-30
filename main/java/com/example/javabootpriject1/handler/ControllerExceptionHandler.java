package com.example.javabootpriject1.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


//全局异常处理器@ControllerAdvice
/*@ControllerAdvice`注解的类将拦截所有使用`@Controller`注解的类中的异常。
`@Controller`是Spring MVC中的注解，用于标识一个类为控制器，它处理HTTP请求并返回响应。
@ControllerAdvice`不会拦截使用其他注解（如`@Service`或`@Component`）的类中的异常。*/
@ControllerAdvice
public class ControllerExceptionHandler {

    //定义一个日志记录器
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    //指定方法处理特定类型的异常，处理所有特定的异常
    @ExceptionHandler(Exception.class)

    //接收两个参数并返回ModelAndView对象，ModelAndView是MVC中储存模型数据和视图的容器
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
        logger.error("Requst URL : {}, Exception :{}",request.getRequestURL());

        ModelAndView mv = new ModelAndView();
        //向mv，添加一个名为urld的属性，addObject（）用于向对象添加模型数据
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception ",e);
        mv.setViewName("error/error");
        return mv;
    }
}
