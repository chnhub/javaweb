package com.testchn.aop;

import com.testchn.aop.impl.MyCalculator;
import com.testchn.aop.inter.Calculator;
import com.testchn.aop.proxy.CalculatorProxy;
import org.junit.jupiter.api.Test;

public class AopTest {
    @Test
    public void test01(){
        System.out.println("hello");
        Calculator calculator = new MyCalculator();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(1,2);

    }
}
