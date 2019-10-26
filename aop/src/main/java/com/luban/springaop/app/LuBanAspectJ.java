package com.luban.springaop.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 21:09
 * @Description:
 */
@Aspect
@Component
public class LuBanAspectJ {

    @Pointcut("execution(* com.luban..*.*(..))")
    public void pointcut(){

    }
    @Pointcut("this(com.luban.springaop.dao.Dao)")
    public void pointcutThis(){

    }
    @Pointcut("target(com.luban.springaop.dao.IndexDao)")
    public void pointcutTarget(){

    }
    @Before(value = "pointcutTarget()")
    public void before(JoinPoint joinPoint){

        System.out.println("before..");
    }

    @After(value = "pointcutTarget()")
    public void after(){
        System.out.println("after");
    }
    @Around(value = "pointcutTarget()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(this.hashCode());
        Object proceed = null;
        Object[] args = proceedingJoinPoint.getArgs();
        if(args!=null&&args.length>0){
            args[0] = args[0]+"哇哇的";
        }
        Arrays.asList(args).forEach(System.out::println);
        try {
            System.out.println("aroundBefore...");
             proceed = proceedingJoinPoint.proceed(args);
            System.out.println("aroundAfter...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
