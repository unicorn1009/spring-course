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

/**
 * Unit test for simple App.
 */
public class MybatisTest
{
    @Test
    public void test1() throws IOException {
        // 使用mybatis读取student数据

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
        List<Student> students = studentDao.selectAllStudent();



        students.forEach(student -> System.out.println(student));
        // 关闭sqlSession对象
        sqlSession.close();

    }

//    @Test
//    public void test2() throws IOException {
//        // 使用mybatis读取student数据
//
//        // 1. 定义mybatis主配置文件的位置, 从类路径下开始
//        String config = "mybatis-config.xml";
//        // 2. 读取这个config表示的文件
//        InputStream inputStream = Resources.getResourceAsStream(config);
//        // 3. SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        // 4. 创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        // 5. [重要] 获取sqlSession对象, 从SqlSessionFactory中获取
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 6. [重要] 指定要执行的sql语句的标识, sql映射文件中的namespace + "." + 标签id值
//        String sqlId = "com.unicorn.dao.StudentDao" + "." + "insertStudent";
//        // 7. 执行sql语句
//        int result = sqlSession.insert(sqlId, new Student(1007, "小黄", 32, "qqq@aaa.com"));
//        System.out.println("执行结果:"+result);
//
//        // 注意 : mybatis默认是不会自动提交事务的, 所以在insert/update/delete操作后要手动提交事务
//        sqlSession.commit();
//
//        // 8. 关闭sqlSession对象
//        sqlSession.close();
//
//    }
}
