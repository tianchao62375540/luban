package com.luban.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: tianchao
 * @Date: 2019/12/27 23:31
 * @Description:
 */
public class SLF4J {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("slf4j");
        logger.info("slf4j....");
    }
}
