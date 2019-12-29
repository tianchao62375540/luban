package com.luban;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/12/22 13:31
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        App bean = context.getBean(App.class);
        System.out.println(bean);
    }
}
