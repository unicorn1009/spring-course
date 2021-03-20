package com.unicorn.dao;

import com.unicorn.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/03/18 14:15
 *
 * @author Unicorn
 */
public interface StudentDao {
    Student getStudentById(Integer id);

    int insertStudent(Student student);

    /**
     * 查询名字为name, 或者年龄大于等于age的学生
     * @param name
     * @param age
     * @return
     */
    List<Student> getStudent(@Param("myname") String name,@Param("myage") Integer age);

    Map<Object, Object> getStudentMap(Integer id);

}
