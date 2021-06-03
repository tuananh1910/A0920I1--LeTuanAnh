package com.example.validationinforuser.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class UserAspect {
    @After(value="execution(* com.example.validationinforuser.service.impl.UserServiceImpl.*(..))")
    public void getUserServiceAfter(){
        System.out.println("After call method get :");
    }


//    @AfterThrowing(pointcut = "execution(public * com.example.validationinforuser.*.*(..))", throwing = "e")
//    public void log(JoinPoint joinPoint,Exception e){
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//    }

//    public void error() {
//        System.out.println("[CMS] ERROR!");
//    }

//    @Before("execution(*.com.example.validationinforuser.service.impl.get*())")
//    public void getAllUserServiceBefore(JoinPoint joinPoint){
//        System.out.println("Before Call method get + " + joinPoint.toString());
//    }
//
//    @After("execution(*.com.example.validationinforuser.*.get*())")
//    public void getAllUserServiceAfter(JoinPoint joinPoint){
//        System.out.println("After call method get +" + joinPoint.toString());
//    }

//    @Pointcut("execution(* com.example.validationinforuser.service.impl.UserServiceImpl.*(..))")
//    private void getUserService(){}


}
