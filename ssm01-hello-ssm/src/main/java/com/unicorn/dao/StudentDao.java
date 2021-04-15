package com.unicorn.dao;

import com.unicorn.entity.Student;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 19:47
 *
 * @author Unicorn
 */
public interface StudentDao {
    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    Integer insertStudent(Student stu);
}
