package com.luban.springaop.test;

import com.luban.springaop.app.AopConfig;
import com.luban.springaop.dao.Dao;
import com.luban.springaop.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 21:15
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Dao dao = (Dao)context.getBean("dao");
        dao.test();
        System.out.println(dao);
        AopConfig aopConfig = (AopConfig)context.getBean("aopConfig");
        aopConfig.haha();
    }
}
