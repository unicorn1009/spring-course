package com.unicorn;

import static org.junit.Assert.assertTrue;

import com.unicorn.dao.StudentDao;
import com.unicorn.domain.Student;
import com.unicorn.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1()
    {
        String configPath = "spring-config.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(configPath);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName + "||||||||||" + app.getBean(beanDefinitionName).getClass().getName());
        }
    }

    // 测试查询
    @Test
    public void test2()
    {
        String configPath = "spring-config.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(configPath);
        StudentDao studentDao = (StudentDao) app.getBean("studentDao");
        List<Student> students = studentDao.selectAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 测试插入
    @Test
    public void test3()
    {
        String configPath = "spring-config.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(configPath);
        StudentDao studentDao = (StudentDao) app.getBean("studentDao");
        int i = studentDao.insertStudent(new Student(1010, "张三丰", 110, "zsf@qq.com"));

    }

    // 测试service
    @Test
    public void test4()
    {
        String configPath = "spring-config.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(configPath);
        StudentService studentService = (StudentService) app.getBean("studentService");
        int i = studentService.addStudent(new Student(1011, "李小龙", 30, "lxl@qq.com"));

    }

    // 测试service
    @Test
    public void test5()
    {
        String configPath = "spring-config.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(configPath);
        StudentService studentService = (StudentService) app.getBean("studentService");
        List<Student> students = studentService.queryAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
