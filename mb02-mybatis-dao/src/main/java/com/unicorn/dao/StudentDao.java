package com.unicorn.dao;

import com.unicorn.domain.Student;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/03/17 20:10
 *
 * @author Unicorn
 */
public interface StudentDao {
    /**
     * 查询所有学生的信息
     * @return
     */
    public List<Student> selectAllStudent();

    /**
     * 插入数据
     * @param student   要插入的数据
     * @return  执行后影响数据库的行数
     */
    public int insertStudent(Student student);
}
