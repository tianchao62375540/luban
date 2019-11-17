package com.luban.Proxy;

import java.lang.reflect.Method;

/**
 * @Auther: tianchao
 * @Date: 2019/11/6 22:32
 * @Description:
 */
public interface CustomInvocationHandler {
    Object invoke(Method method, Object args);
}
