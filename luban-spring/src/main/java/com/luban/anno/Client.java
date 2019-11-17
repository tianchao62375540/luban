package com.luban.anno;

import com.luban.anno.spring.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 19:53
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.luban.anno.service");
    }
}
