package com.luban.anno.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Auther: tianchao
 * @Date: 2019/11/17 19:52
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String value();
}
