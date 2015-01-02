package com.ibm.configuration;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Karim on 23/12/2014.
 */
public class MyBatisSqlSessionFactory {

    private static Logger logger = LoggerFactory.getLogger(MyBatisSqlSessionFactory.class);

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory==null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                if(logger.isDebugEnabled()) {
                    logger.debug("erreur instanciation de la session sql : "+e.getCause());
                }
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();
    }
}
