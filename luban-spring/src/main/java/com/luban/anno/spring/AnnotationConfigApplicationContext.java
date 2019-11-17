package com.luban.anno.spring;

import com.luban.anno.anno.Service;

import java.io.File;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 19:50
 * @Description:
 */
public class AnnotationConfigApplicationContext {
    public void scan(String _package){
        String path = this.getClass().getResource("/").getPath();
        String classPath = _package.replaceAll("\\.","/");
        File rootfile = new File(path+"/"+classPath);
        File[] files = rootfile.listFiles();
        for (File file : files){
            String name = file.getName().substring(0,file.getName().lastIndexOf("."));
            Class<?> aClass = null;
            try {
                aClass = Class.forName(_package + "." + name);
                if (aClass.isAnnotationPresent(Service.class)){
                    Service annotation = aClass.getAnnotation(Service.class);
                    System.out.println(annotation.value());
                }
                System.out.println(aClass.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(path);

    }
}
