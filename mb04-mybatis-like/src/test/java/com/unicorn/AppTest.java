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
        List<Student> students = studentDao.selectStudentLikeName("张%");
        students.forEach(s-> System.out.println(s));

        sqlSession.close();

    }
}
