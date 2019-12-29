package com.luban.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Auther: tianchao
 * @Date: 2019/12/27 20:55
 * @Description:
 * JCL是通过log4j打印的
 * 没有log4j 打印org.apache.commons.logging.impl.Jdk14Logger 用的jul
 */
public class JCL {
    public static void main(String[] args) {
        Log loger = LogFactory.getLog("jcl");
        loger.info("jcl..................."+loger.getClass());
        /**
         * [INFO ] 2019-12-27 20:57:34,336 method:com.luban.Test.JCL.main(JCL.java:14)
         * jcl
         */
    }
}
