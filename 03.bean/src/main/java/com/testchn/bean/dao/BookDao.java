package com.testchn.bean.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("bookdaohaha")
@Scope("prototype")
public class BookDao {
    public void saveBook(){
        System.out.println("保存图书");
    }
    public void save(){
        System.out.println("保存图书");
    }
}
