package com.testchn.bean.dao;

import com.testchn.bean.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao extends BaseDao<Car>{
    @Override
    public void save(){
        System.out.println("保存Car");
    }
}
