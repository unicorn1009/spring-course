package com.unicorn.dao;

import com.unicorn.domain.Student;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/20 13:37
 *
 * @author Unicorn
 */
public interface StudentDao {
    List<Student> selectAllStudent();
    int  insertStudent(Student student);

}
