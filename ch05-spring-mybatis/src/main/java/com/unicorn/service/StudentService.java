package com.unicorn.service;

import com.unicorn.domain.Student;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/20 15:16
 *
 * @author Unicorn
 */
public interface StudentService {
    int addStudent(Student student);

    List<Student> queryAllStudent();
}
