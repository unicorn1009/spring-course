package com.unicorn;

import static org.junit.Assert.assertTrue;

import com.unicorn.service.ITeacherService;
import com.unicorn.service.impl.TeacherServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    // 测试前置通知
    @Test
    public void testAspect1()
    {
        String config = "applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        // aspectJ框架会生成代理对象返回, 使用的是JDK动态代理
        ITeacherService proxy = (ITeacherService)app.getBean("teacherService");
        // com.sun.proxy.$Proxy15 是代理类型
        System.out.println("proxy : "+proxy.getClass().getName());  //com.sun.proxy.$Proxy15 代理类型
        proxy.teach("三年二班");

    }


    // 测试后置通知
    // 返回值是String, 不可变类型, 代理对返回值进行修改, 结果没有影响.
    @Test
    public void testAspect2()
    {
        String config = "applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        // aspectJ框架会生成代理对象返回, 使用的是JDK动态代理
        ITeacherService proxy = (ITeacherService)app.getBean("teacherService");
        // com.sun.proxy.$Proxy15 是代理类型
        System.out.println("proxy : "+proxy.getClass().getName());  //com.sun.proxy.$Proxy15 代理类型
        // 由于是String, 不可变, 返回值是目标函数的返回值
        String ret = proxy.sayHello("张三");
        System.out.println(ret);
    }

    // 返回值是引用类型, 引用传递, 代理对返回值进行修改, 结果会影响.
    @Test
    public void testAspect3()
    {
        String config = "applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        // aspectJ框架会生成代理对象返回, 使用的是JDK动态代理
        ITeacherService proxy = (ITeacherService)app.getBean("teacherService");
        // com.sun.proxy.$Proxy15 是代理类型
        System.out.println("proxy : "+proxy.getClass().getName());  //com.sun.proxy.$Proxy15 代理类型
        // 由于是Student, 引用类型, 返回值被修改
        Student ret = proxy.getStudent("张三");
        System.out.println(ret);
    }

    // 测试环绕通知
    @Test
    public void testAspect4()
    {
        String config = "applicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        // aspectJ框架会生成代理对象返回, 使用的是JDK动态代理
        ITeacherService proxy = (ITeacherService)app.getBean("teacherService");
        // com.sun.proxy.$Proxy15 是代理类型
        System.out.println("proxy : "+proxy.getClass().getName());  //com.sun.proxy.$Proxy15 代理类型
        // 由于是Student, 引用类型, 返回值被修改
        String ret = proxy.sayHello("张三");
        System.out.println(ret);
    }
}
