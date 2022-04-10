package com.testchn.bean.servlet;

import com.testchn.bean.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookServlet {
    @Qualifier("bookService1")
    @Autowired(required = false)
    private BookService bookServiceExt;
    public void doGet(){
        System.out.println("BookServlet:"+bookServiceExt);
//        bookServiceExt.save();
    }
}
