package com.unicorn;

import static org.junit.Assert.assertTrue;

import com.unicorn.dao.StudentDao;
import com.unicorn.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    // 测试like模糊查询第一种方式
    @Test
    public void test1() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();



        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = studentDao.selectStudentIf(null, 20);
        students.forEach(s-> System.out.println(s));

        sqlSession.close();

    }
}
