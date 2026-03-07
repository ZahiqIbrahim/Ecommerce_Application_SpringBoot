package com.example.SpringEcom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
@Aspect
public class LoggingAspect {



    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public LoggingAspect() throws IOException {
    }

    //execution(return type, class name, method name, args)
    @Before("execution(* com.example.SpringEcom.controller.ProductController.*(..))")
    public void logMethodCall(JoinPoint jp){

        LOGGER.info(jp.getSignature().getName() +" Method Called");
    }

    @After("execution(* com.example.SpringEcom.controller.ProductController.*(..))") // all return types ,all classes in this package, all methods, any arguments
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName() +" Method Executed");
    }

    //if method runs into an error
    @AfterThrowing("execution(* com.example.SpringEcom.controller.ProductController.*(..))")
    public void logMethodCrashed(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName() +" Method has some Errors");
    }

    //if method runs fully
    @AfterReturning("execution(* com.example.SpringEcom.controller.ProductController.*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName() +" Method Executed Successfully");
    }

}
