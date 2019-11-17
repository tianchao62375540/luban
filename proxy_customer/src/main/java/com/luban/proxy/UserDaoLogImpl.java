package com.luban.proxy;

import com.luban.dao.UserDaoImpl;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:31
 * @Description:
 */
public class UserDaoLogImpl extends UserDaoImpl {
    @Override
    public String getUserById(Long id) {
        System.out.println("-------------log------------------"+this);
        String userById = super.getUserById(id);
        System.out.println("-------------log------success------------");
        return userById;
    }
}
