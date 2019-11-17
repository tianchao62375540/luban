package com.luban.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 16:49
 * @Description:
 */
@Configuration
@ImportResource(value = {"classpath:factorybean.xml"})
public class ConfigSql {
}
