package com.tw.todolist.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory(){

        if(sqlSessionFactory==null)
        {
            InputStream inputStream = null;
            try
            {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e)
            {
                throw new RuntimeException(e.getCause());
            }finally {
                if(inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession()
    {
        return getSqlSessionFactory().openSession();
    }
}
