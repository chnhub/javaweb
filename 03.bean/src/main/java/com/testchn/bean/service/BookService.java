package com.testchn.bean.service;

import com.testchn.bean.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService1")
public class BookService {
    @Autowired
    private BookDao bookDao;
    public void save(){
        System.out.println("BookService：正在保存图书");
        bookDao.saveBook();
    }
}
