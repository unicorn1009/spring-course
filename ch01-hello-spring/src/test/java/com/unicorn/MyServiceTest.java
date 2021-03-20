package com.unicorn;

import com.unicorn.service.IMyService;
import com.unicorn.service.impl.MyServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MyServiceTest {

    @Test
    public void test1(){
        MyServiceImpl service = new MyServiceImpl();
        service.doSomething();
    }

    @Test
    public void test2(){
        // 使用spring容器创建的对象
        // 1. 指定spring配置文件的名称
        String config = "beans.xml";
        // 2. 创建表示spring容器的对象，ApplicationContext
        // ClassPathXmlApplicationContext是从类路径下去加载配置文件的

        ApplicationContext app = new ClassPathXmlApplicationContext(config);

        // 在将app对象创建出来时, 容器就会创建配置文件中指定的所有bean对象

        // 从容器中获取对象
        Object myService = app.getBean("myService");
        if (myService instanceof IMyService) {
            ((IMyService) myService).doSomething();
        }
    }

    @Test
    public void test3(){

        String config = "beans.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);

        // 获取容器中bean的信息
        // 使用spring提供的方法
        int beanDefinitionCount = app.getBeanDefinitionCount(); // 容器中对象数量
        System.out.println(beanDefinitionCount);

        String[] names = app.getBeanDefinitionNames();  // 容器中所有对象的名称
        System.out.println(Arrays.toString(names));

    }
}
