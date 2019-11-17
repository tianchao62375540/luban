package com.luban.proxy;

import com.luban.dao.UserDaoImpl;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:31
 * @Description:
 */
public class UserDaoPowerImpl extends UserDaoLogImpl {
    @Override
    public String getUserById(Long id) {
        System.out.println("-------------权限------------------"+this);
        String userById = super.getUserById(id);
        System.out.println("-------------权限-----  end -------");
        return userById;
    }
}
