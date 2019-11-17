package com.luban.Proxy;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: tianchao
 * @Date: 2019/11/10 09:30
 * @Description:
 */
public class JdkImplInvocaltionHandler implements InvocationHandler {
    private Object target;

    public JdkImplInvocaltionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk-=====before");
        Object invoke = method.invoke(target, args);
        System.out.println("jdk-=====after");
        return invoke;
    }
}
