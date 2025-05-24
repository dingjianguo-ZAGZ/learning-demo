package com.su.test;

import com.su.mapper.UserMapper;
import com.su.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建 sqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //构造器读取配置文件创建工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取操作数据库的mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //操作数据库
        List<User> userList = mapper.findAll();
        userList.forEach(user -> System.out.println(user));
        System.out.println("over...");
    }
}
