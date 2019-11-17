package com.luban.Proxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;

/**
 * @Auther: tianchao
 * @Date: 2019/10/30 23:22
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, MalformedURLException, ClassNotFoundException {

        ItemDao target = new ItemDaoImpl();
        ItemDao proxy = (ItemDao)Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{ItemDao.class}, new JdkImplInvocaltionHandler(target));
        int sum = proxy.sum(3, 5);
        System.out.println(sum);

    }
}
