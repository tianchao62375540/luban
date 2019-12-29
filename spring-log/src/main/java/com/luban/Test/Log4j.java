package com.luban.Test;


import org.apache.log4j.Logger;

/**
 * @Auther: tianchao
 * @Date: 2019/12/27 20:47
 * @Description:
 */
public class Log4j {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("log4j");
        logger.info("log4j....."+logger.getClass());
    }
}
