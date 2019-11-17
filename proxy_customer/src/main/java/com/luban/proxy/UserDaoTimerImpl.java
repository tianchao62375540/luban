package com.luban.proxy;

import com.luban.dao.UserDaoImpl;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:31
 * @Description:
 */
public class UserDaoTimerImpl extends UserDaoPowerImpl {
    @Override
    public String getUserById(Long id) {
        System.out.println("-------------时间------------------");
        String userById = super.getUserById(id);
        System.out.println("-------------时间-----  end -------");
        return userById;
    }
}
