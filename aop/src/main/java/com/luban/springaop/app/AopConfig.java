package com.luban.springaop.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 21:08
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
@ComponentScan(value ={"com.luban.springaop"} )
public class AopConfig {
    public void haha(){
        System.out.println("haha");
    }
}
