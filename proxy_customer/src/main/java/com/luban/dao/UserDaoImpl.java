package com.luban.dao;

/**
 * @Auther: tianchao
 * @Date: 2019/10/27 09:29
 * @Description:
 */
public class UserDaoImpl implements UserDao{
    public String getUserById(Long id){
        System.out.println("UserDaoImpl getUserById"+this);
        return "User"+id;
    }
}
