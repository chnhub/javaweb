package com.testchn.aop;

import com.testchn.aop.impl.MyCalculator;
import com.testchn.aop.inter.Calculator;
import com.testchn.aop.proxy.CalculatorProxy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public ConfigurableApplicationContext ioc = new  ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test01(){
        System.out.println("hello");
        Calculator calculator = new MyCalculator();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(1,2);

    }

    /**
     * 通知方法执行顺序
     * 正常执行：@Before("前置通知")-->@After(后置通知)-->AfterReturning(正常返回)
     * 异常执行：@Before("前置通知")-->@After(后置通知)-->AfterThrowing(异常返回)
     *
     */
    @Test
    public void test02(){
        //一定用接口类型
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
        Calculator calculator1 = (Calculator) ioc.getBean("myCalculator");
        calculator1.add(2,3);
        //没有接口时就是本类，cglib会帮我们创建
        //MyCalculator my = (MyCalculator) ioc.getBean(MyCalculator.class);
        //my.add(2,3);


    }
}
