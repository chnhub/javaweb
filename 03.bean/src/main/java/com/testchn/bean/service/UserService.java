package com.testchn.bean.service;

import com.testchn.bean.dao.BaseDao;
import com.testchn.bean.dao.UserDao;
import com.testchn.bean.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{
//    @Autowired
//    private BaseDao<User> baseDao;
//    public void save(){
//        baseDao.save();
//    }
}
