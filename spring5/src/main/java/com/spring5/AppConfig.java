package com.spring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

/**
 * @Auther: tianchao
 * @Date: 2019/12/29 09:24
 * @Description:
 */
@Configuration
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
    }
}
