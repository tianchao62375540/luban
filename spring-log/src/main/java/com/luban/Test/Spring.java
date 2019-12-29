package com.luban.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Auther: tianchao
 * @Date: 2019/12/28 22:38
 * @Description:
 */
public class Spring {
    public static void main(String[] args) {
        Log logger = LogFactory.getLog("sping");
        logger.info("spring..."+logger.getClass());
    }
}
