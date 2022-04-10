package com.testchn.bean.model;

import lombok.Data;

@Data
public class Book {
    private String name;
    public void initBook(){
        System.out.println("book对象被创建了");
    }
    Book(){
        System.out.println("book对象构造方法");
    }
    public void destroyBook(){
        System.out.println("book对象被销毁了");
    }
}
