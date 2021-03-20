package com.unicorn.service.impl;

import com.unicorn.Student;
import com.unicorn.service.ITeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 * Created on 2021/3/15 0015
 *
 * @author Unicorn
 */
@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {
    @Override
    public void teach(String classroom) {
        System.out.println("老师正在给"+classroom+"上课");
    }

    @Override
    public String sayHello(String name) {
        System.out.println("老师对"+name+"说你好");
        return "我是返回值";
    }

    @Override
    public Student getStudent(String name) {
        return new Student(name);
    }
}

