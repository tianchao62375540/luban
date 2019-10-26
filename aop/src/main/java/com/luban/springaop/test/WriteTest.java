package com.luban.springaop.test;

import com.luban.springaop.app.AopConfig;
import com.luban.springaop.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Proxy;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 23:29
 * @Description:
 */
public class WriteTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("IndexDao&Proxy", new Class[]{Dao.class});
        String path = WriteTest.class.getClassLoader().getResource("").getPath();

        File file = new File(path+"IndexDao&Proxy.class");
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.close();
        os.flush();
        System.out.println("success......");
    }
}
