package com.testchn.bean.dao;

import com.testchn.bean.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User>{
    public void saveBook(){
        System.out.println("保存用户");
    }
    @Override
    public void save(){
        System.out.println("保存用户");
    }
}
