package com.luban.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/10/23 20:04
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        IndexService service = (IndexService)context.getBean("service");
        IndexService service1 = (IndexService)context.getBean("service");
        System.out.println(service.getDao());
        service.test();
        System.out.println(service1.getDao());
        service1.test();
    }
}
