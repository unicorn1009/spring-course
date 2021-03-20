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

    List<Student> selectStudentIf(@Param("myname") String name, @Param("myage") int age);

}
