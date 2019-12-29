package com.luban.Test;

import java.util.logging.Logger;

/**
 * @Auther: tianchao
 * @Date: 2019/12/27 20:48
 * @Description:
 */
public class JUL {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("jul");
        logger.info("jul..............."+logger.getClass());
    }
}
