package com.unicorn.service.impl;

import com.unicorn.service.IMyService;

public class MyServiceImpl implements IMyService {

    public MyServiceImpl() {
        System.out.println("执行MyServiceImpl的无参构造函数");
    }

    @Override
    public void doSomething() {
        System.out.println("执行了MyServiceImpl中的doSomething方法");
    }
}
