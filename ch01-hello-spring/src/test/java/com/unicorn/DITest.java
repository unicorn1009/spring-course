package com.unicorn;

import com.unicorn.entity.Employee;
import com.unicorn.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void test1()
    {
        // 测试依赖注入
        String config = "ba01/applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("student");
        Student student = (Student) bean;
        System.out.println(student);        // Student{name='null', age=null}

        // 如何给属性赋值
    }

    @Test
    public void test2()
    {
        // 通过set给简单属性赋值
        String config = "ba01/applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("student1");
        Student student = (Student) bean;
        System.out.println(student);        // Student{name='张三', age=23}
    }


    @Test
    public void test3()
    {
        // 通过set给引用类型属性赋值
        String config = "ba01/applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("employee");
        Employee employee = (Employee) bean;
        System.out.println(employee);        // Employee{name='李四', age=32, company=Company{name='腾讯', address='深圳市南山区'}}
    }

    @Test
    public void test4()
    {
        // 通过构造器给属性赋值
        String config = "ba01/applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("student2");
        Student student = (Student) bean;
        System.out.println(student);        // Student{name='王五', age=25}
    }

    @Test
    public void test5()
    {
        // 自动注入
        String config = "ba02/applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        Object bean = app.getBean("employee1");
        Employee employee = (Employee) bean;
        System.out.println(employee);

    }
}
