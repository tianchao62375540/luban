package com.luban.service;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;

/**
 * @Auther: tianchao
 * @Date: 2019/11/14 22:56
 * @Description:
 */
public class UserServiceImpl implements UserService {
    UserDao dao;
    public UserServiceImpl(){

    }
    public UserServiceImpl(UserDao dao){
        this.dao = dao;
    }
    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }
}
