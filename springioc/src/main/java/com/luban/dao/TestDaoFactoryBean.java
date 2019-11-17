package com.luban.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/11/10 10:33
 * @Description:
 */
public class TestDaoFactoryBean {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DaoFactoryBean daoFactoryBean = (DaoFactoryBean)context.getBean("&daoFactoryBean");
        DaoFactoryBean daoFactoryBean1 = (DaoFactoryBean)context.getBean("&daoFactoryBean");
        System.out.println(daoFactoryBean);
        System.out.println(daoFactoryBean1);
        System.out.println(daoFactoryBean.getObject());
        System.out.println(daoFactoryBean.getObject());
        TempDaoFactoryBean tempdaoFactoryBean = (TempDaoFactoryBean)context.getBean("daoFactoryBean");
        TempDaoFactoryBean tempdaoFactoryBean1 = (TempDaoFactoryBean)context.getBean("daoFactoryBean");
        System.out.println(tempdaoFactoryBean);
        System.out.println(tempdaoFactoryBean1);
        tempdaoFactoryBean.test();
    }
}
