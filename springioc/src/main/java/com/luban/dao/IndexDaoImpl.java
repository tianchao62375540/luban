package com.luban.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2019/10/23 19:59
 * @Description:
 */
@Component(value = "dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("IndexDaoImpl  test");
    }
}
