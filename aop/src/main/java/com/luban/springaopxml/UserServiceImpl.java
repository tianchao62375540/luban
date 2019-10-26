package com.luban.springaopxml;

/**
 * @Auther: tianchao
 * @Date: 2019/10/26 23:52
 * @Description:
 */
public class UserServiceImpl implements UserService{
    @Override
    public String getUserById(Long id) {
        return "hello :"+id;
    }
}
