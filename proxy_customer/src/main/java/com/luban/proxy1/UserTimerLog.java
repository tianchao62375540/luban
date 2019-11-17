package com.luban.proxy1;

import com.luban.dao.UserDao;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 10:08
 * @Description:
 */
public class UserTimerLog implements UserDao {
    private UserDao userDao;

    public UserTimerLog(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String getUserById(Long id) {
        System.out.println("timer=--------------------");
        String str = userDao.getUserById(id);
        System.out.println("timer=---------end-----------");
        return str;
    }
}
