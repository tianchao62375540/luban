package com.luban.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 创建被spring管理的对象的一种方式
 *
 * @Auther: tianchao
 * @Date: 2019/11/10 10:31
 * @Description:
 */
//@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {
    private String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Object getObject() throws Exception {
        TempDaoFactoryBean tempDaoFactoryBean = new TempDaoFactoryBean();
        if (msg != null && !"".equals(msg)) {
            String[] split = msg.split(",");
            tempDaoFactoryBean.setMsg1(split[0]);
            tempDaoFactoryBean.setMsg2(split[1]);
            tempDaoFactoryBean.setMsg3(split[2]);
        }
        return tempDaoFactoryBean;
    }

    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void test() {
        System.out.println("DaoFactoryBean");
    }
}
