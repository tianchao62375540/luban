package com.luban.springaopxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 00:01
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaop.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        String userById = userService.getUserById(15L);
        System.out.println(userById);
    }
}
