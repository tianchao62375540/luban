package com.luban.dao;

import org.junit.Test;
import org.springframework.lang.NonNull;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 17:19
 * @Description:
 */
public class TestAll {
    @Test
    public void test1(){
        TestAll testAll = new TestAll();
        testAll.testMethod(null);
    }

    public void testMethod(@NonNull String str){
        System.out.println(str);
    }
}
