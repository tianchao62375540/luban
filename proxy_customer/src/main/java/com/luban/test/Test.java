package com.luban.test;

import com.luban.dao.UserDaoImpl;
import com.luban.proxy.UserDaoLogImpl;
import com.luban.proxy.UserDaoPowerImpl;
import com.luban.proxy.UserDaoTimerImpl;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:30
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoTimerImpl();
        String userById = userDao.getUserById(111L);
        System.out.println(userById);
    }
}
