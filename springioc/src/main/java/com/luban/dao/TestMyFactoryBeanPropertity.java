package com.luban.dao;

import com.luban.config.ConfigSql;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 16:42
 * @Description:
 */
public class TestMyFactoryBeanPropertity {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:factorybean.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigSql.class);
        TempDaoFactoryBean mySqlSessionFactory = (TempDaoFactoryBean)context.getBean("mySqlSessionFactory");
        mySqlSessionFactory.test();
    }
}
