package com.luban.proxy1;

import com.luban.dao.UserDao;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:45
 * @Description:
 */
public class UserDaoLog implements UserDao {
    UserDao userDao;

    public UserDaoLog(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String getUserById(Long id) {
        System.out.println("log------------------"+this);
        return userDao.getUserById(id);
    }
}
