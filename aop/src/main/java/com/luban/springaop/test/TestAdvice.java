package com.luban.springaop.test;

import com.luban.springaop.app.AopConfig;
import com.luban.springaop.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/10/26 21:48
 * @Description:
 */
public class TestAdvice {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Dao dao = (Dao)context.getBean("dao");
        Dao dao1 = (Dao)context.getBean("dao");
        dao.test();
        dao1.test();
        System.out.println(dao.hashCode()+"==========================="+dao1.hashCode());
        String str = dao.insert("你好啊");
        System.out.println("调用者："+str);
    }
}
