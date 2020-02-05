package com.newer.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    //用于生产数据库连接会话对象的工厂对象
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //读取配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //初始化连接工厂对香港
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //获取数据库连接会话对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //关闭资源
    public  static  void close(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
    }
}
