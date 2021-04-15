package com.unicorn.service;

import com.unicorn.entity.Student;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 20:02
 *
 * @author Unicorn
 */
public interface StudentService {
    int addStudent(Student stu);
    List<Student> getAllStudents();
    Student getStudent(int id);
}
