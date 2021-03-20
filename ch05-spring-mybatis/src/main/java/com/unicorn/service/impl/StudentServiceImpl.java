package com.unicorn.service.impl;

import com.unicorn.dao.StudentDao;
import com.unicorn.domain.Student;
import com.unicorn.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/20 15:17
 *
 * @author Unicorn
 */
public class StudentServiceImpl implements StudentService {


    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryAllStudent() {
        List<Student> students = studentDao.selectAllStudent();
        return students;
    }
}
