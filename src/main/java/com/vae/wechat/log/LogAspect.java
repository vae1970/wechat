package com.vae.wechat.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Aspect
public class LogAspect {

    @After("execution(* com.vae.wechat.controller.LoginController.login(int,String)) && args(number,string)")
    public void login (int number,String string){
        System.out.println("log login" + number + "   " + string);
    }

    @Around("execution(* com.vae.wechat.dao.*.*(..))")
    public void dao (ProceedingJoinPoint pjp) {
        Date startDate = new Date();
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            Date endDate = new Date();
            long timeDifference = endDate.getTime()-startDate.getTime();
            System.out.println(timeDifference);

        }

    }


}
