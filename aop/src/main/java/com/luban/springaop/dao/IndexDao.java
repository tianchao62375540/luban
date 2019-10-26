package com.luban.springaop.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 21:09
 * @Description:
 */
@Component(value = "dao")
@Scope("prototype")
public class IndexDao implements Dao {
    @Override
    public void test(){
        System.out.println("IndexDao test()");
    }

    @Override
    public String insert(String str) {
        return str+"田超";
    }
}
