package com.luban.app;

import com.luban.service.CardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2019/12/6 23:41
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CardService bean = context.getBean(CardService.class);
        bean.list();
    }
}
