package com.luban.test;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.proxy1.UserDaoLog;
import com.luban.proxy1.UserTimerLog;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:47
 * @Description:
 */
public class TestExtends {
    public static void main(String[] args) {
        UserDao target = new UserDaoImpl();
        UserDao target1 = new UserDaoLog(target);
        UserDao proxy = new UserTimerLog(target1);
        String userById = proxy.getUserById(15L);
        System.out.println(userById);
    }
}
