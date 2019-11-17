package com.luban.test;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.service.UserService;
import com.luban.service.UserServiceImpl;
import com.luban.spring.BeanFactory;

/**
 * @Auther: tianchao
 * @Date: 2019/11/14 22:57
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
       /* UserService userService = new UserServiceImpl();
        userService.find();*/
        String xml = "";
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserDao dao = (UserDao)beanFactory.getBean("dao");
        System.out.println(dao);
        UserService service = (UserService)beanFactory.getBean("service");
        System.out.println(service);
        System.out.println("======================================");
        UserService userService = (UserService)beanFactory.getBean("service");
        userService.find();
    }
    @org.junit.Test
    public void test(){
        boolean assignableFrom = UserDao.class.isAssignableFrom(UserDaoImpl.class);
        System.out.println(assignableFrom);
    }
}
