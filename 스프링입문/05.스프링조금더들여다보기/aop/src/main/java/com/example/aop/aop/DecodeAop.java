package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){ }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode(){}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();

        for(Object arg: args){
            User user = User.class.cast(arg);
            String base64Email = user.getEmail();

            user.setEmail(Base64.getDecoder().decode()); ///////////////////////////////--여기부터
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){

    }
}
