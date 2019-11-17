package com.luban.moudle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 18:14
 * @Description:
 */
public class TestConfig {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context.register(MoudleService.class);
        //context.refresh();
        context.scan("com.luban.moudle");
        MoudleService bean = context.getBean(MoudleService.class);
        System.out.println(bean);

    }
}
