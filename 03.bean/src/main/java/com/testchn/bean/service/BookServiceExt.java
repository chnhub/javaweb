package com.testchn.bean.service;

import org.springframework.stereotype.Service;

@Service
public class BookServiceExt extends BookService{
    @Override
    public void save(){
        System.out.println("BookServiceExt：重写save");
    }
}
