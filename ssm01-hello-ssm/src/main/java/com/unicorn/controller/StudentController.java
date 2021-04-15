package com.unicorn.controller;

import com.unicorn.entity.Student;
import com.unicorn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 20:15
 *
 * @author Unicorn
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 获取所有学生
    @ResponseBody
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        System.out.println("进入service处理器");
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    // 测试统一异常处理
    @ResponseBody
    @RequestMapping(value = "/testexception", method = RequestMethod.GET)
    public void testExceptionHandler(){
        System.out.println("进入service处理器");
        throw new RuntimeException("发生异常");
    }

    @ResponseBody
    @RequestMapping(value = "/testinterceptor", method = RequestMethod.GET)
    public Object testinterceptor(){
        System.out.println("测试拦截器");
        return "拦截器测试";
    }

}
