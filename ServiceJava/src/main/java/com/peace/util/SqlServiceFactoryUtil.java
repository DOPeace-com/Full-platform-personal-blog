package com.peace.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlServiceFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            String r = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(r);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
