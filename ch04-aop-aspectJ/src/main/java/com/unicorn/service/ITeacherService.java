package com.unicorn.service;

import com.unicorn.Student;

/**
 * <p>
 * </p>
 * Created on 2021/3/15 0015
 *
 * @author Unicorn
 */
public interface ITeacherService {
    void teach(String classroom);
    String sayHello(String name);
    Student getStudent(String name);
}
