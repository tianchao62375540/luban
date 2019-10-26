package com.luban.util;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 20:00
 * @Description:
 */

import com.luban.anno.MyEntity;

/**
 * 通过一个java对象构建一条查询的sql
 */
public class CommUtil {
    public static String buildQuerySqlForEntity(Object object){
        Class<?> clazz = object.getClass();
        //1判断是否加了注解
        boolean annotationPresent = clazz.isAnnotationPresent(MyEntity.class);
        if (annotationPresent){
            //2获取注解
            MyEntity annotation = clazz.getAnnotation(MyEntity.class);
            //3调用方法
            String value = annotation.value();
            System.out.println(value);
        }
        System.out.println(annotationPresent);
        return null;
    }
}
