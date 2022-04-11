package com.testchn.aop.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtils {
    @Pointcut(value = "execution(public int com.testchn.aop.impl.MyCalculator.add(int, int))")
    public void pointCut(){};
    //execution(访问权限符 返回值类型 方法签名)
    //需要告诉spring用result接受返回值
    @Before(value = "pointCut()")
    public static void logStart(JoinPoint joinPoint){
        //获取参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法，log开始执行，参数列表："+ Arrays.asList(args));
    }
    @AfterReturning(value = "execution(public int com.testchn.aop.impl.MyCalculator.add(int, int))",returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result){
        System.out.println("log返回后执行");
        //获取参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法，log开始执行，参数列表："+ Arrays.asList(args)+"结果为："+ result.toString());
    }
    @After("execution(public int com.testchn.aop.impl.MyCalculator.add(int, int))")
    public static void logAfter(){
        System.out.println("log方法执行结束");
    }
    @AfterThrowing(value = "execution(public int com.testchn.aop.impl.MyCalculator.add(int, int))",throwing = "exception")
    public static void logThrowing(JoinPoint joinPoint, Exception exception){

        System.out.println("log方法执行结束");
    }
}
