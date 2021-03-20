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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1() throws IOException {
        // 1. 定义mybatis主配置文件的位置, 从类路径下开始
        String config = "mybatis-config.xml";
        // 2. 读取这个config表示的文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 3. SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 5. [重要] 获取sqlSession对象, 从SqlSessionFactory中获取, 参数true代表获取一个自动提交事务的SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();



        // [重要][重要]mybatis使用动态代理动态生成代理对象, 执行代理对象的方法执行sql语句
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("studentDao = " + studentDao);   // org.apache.ibatis.binding.MapperProxy@5a8806ef
        Student student = studentDao.getStudentById(1002);
        System.out.println("student = " + student);



        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("studentDao = " + studentDao);
        int rows = studentDao.insertStudent(new Student(1009, "赵云", 20, "zy@qq.com"));
        System.out.println("rows = " + rows);


        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("studentDao = " + studentDao);
        List<Student> students = studentDao.getStudent("张飞", 20);
        students.forEach(student -> System.out.println("student = " + student));


        sqlSession.close();
    }

    // 测试返回值为Map类型
    @Test
    public void test4() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("studentDao = " + studentDao);
        Map<Object, Object> studentMap = studentDao.getStudentMap(1003);
        System.out.println("studentMap = " + studentMap);


        sqlSession.close();
    }
}
