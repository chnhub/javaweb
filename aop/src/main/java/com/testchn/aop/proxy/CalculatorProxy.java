package com.testchn.aop.proxy;

import com.testchn.aop.impl.MyCalculator;
import com.testchn.aop.inter.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy{
    public static Calculator getProxy(Calculator calculator){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object oj =  method.invoke(calculator, args);
                System.out.println("使用代理打印日志："+oj.toString());
                return oj;
            }
        };
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader loader = calculator.getClass().getClassLoader();
        Object proxy = Proxy.newProxyInstance(loader, interfaces,h);
        return (Calculator)proxy;
    }
}
