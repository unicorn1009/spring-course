package com.unicorn;

import com.unicorn.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void test1()
    {
        // 测试依赖注入
        String config = "ba01/main.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("employee");
        Employee employee = (Employee) bean;
        System.out.println(employee);        // Employee{name='李四', age=32, company=Company{name='腾讯', address='深圳市南山区'}}

    }

}
