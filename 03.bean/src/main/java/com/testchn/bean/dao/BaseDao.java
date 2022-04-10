package com.testchn.bean.dao;

import org.springframework.beans.factory.annotation.Autowired;

abstract public class BaseDao <T>{
    abstract public void save();
}
