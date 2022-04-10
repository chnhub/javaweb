package com.testchn.bean;

import com.testchn.bean.dao.BookDao;
import com.testchn.bean.model.Person;
import com.testchn.bean.model.User;
import com.testchn.bean.service.BaseService;
import com.testchn.bean.service.BookService;
import com.testchn.bean.service.CarService;
import com.testchn.bean.service.UserService;
import com.testchn.bean.servlet.BookServlet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestClass {

//    @Qualifier("bookdaohaha")
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");

    @Test
    public void test01(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("IOC.xml");
        Person person = (Person)ioc.getBean("person");
        System.out.println(person.toString());
    }
    @Test
    public void test02(){
        ioc.close();
    }
    @Test
    public void test03(){
        BookDao bookDao = (BookDao)ioc.getBean("bookdaohaha");
        BookDao bookDao2 = (BookDao)ioc.getBean("bookdaohaha");
        System.out.println(bookDao==bookDao2);
    }
    @Test
    public void test04(){
        BookServlet bookServlet = (BookServlet)ioc.getBean(BookServlet.class);
        bookServlet.doGet();
    }
    @Test
    public void test05(){
//        BookService bookService = (BookService)ioc.getBean("bookService1");
//        bookService.save();
        UserService userService = (UserService) ioc.getBean(BaseService.class);
        CarService carService = ioc.getBean(CarService.class);
        userService.save();
        carService.save();
    }
    @Test
    public void test06(){
        //依赖泛型注入
        UserService userService = ioc.getBean(UserService.class);
        CarService carService = ioc.getBean(CarService.class);
        userService.save();
        carService.save();
    }

}
