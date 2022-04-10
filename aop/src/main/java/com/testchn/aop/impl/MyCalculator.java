package com.testchn.aop.impl;

import com.testchn.aop.inter.Calculator;

public class MyCalculator implements Calculator {

    @Override
    public int add(int a, int b) {
        System.out.println("add:"+(a+b));
        return a+b;
    }
}
