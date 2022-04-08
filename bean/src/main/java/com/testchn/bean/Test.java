package com.testchn.bean;

import com.testchn.bean.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
        Person person = (Person)ioc.getBean("person");
        System.out.println(person.getAge());
    }
}
