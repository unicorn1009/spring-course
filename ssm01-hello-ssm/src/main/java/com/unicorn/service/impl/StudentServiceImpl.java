package com.unicorn.service.impl;

import com.unicorn.dao.StudentDao;
import com.unicorn.entity.Student;
import com.unicorn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 20:04
 *
 * @author Unicorn
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student stu) {
        Student student = new Student(2001, "江小白", 33, "jxb@qq.com");
        Integer res = studentDao.insertStudent(student);
        return res;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudent = studentDao.getAllStudent();
        return allStudent;
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentDao.getStudentById(id);
        return student;
    }
}
