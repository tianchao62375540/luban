package com.luban.dao;

/**
 * @Auther: tianchao
 * @Date: 2019/11/10 10:32
 * @Description:
 */
public class TempDaoFactoryBean {
    private String msg1;
    private String msg2;
    private String msg3;


    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }


    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }


    public void setMsg3(String msg3) {
        this.msg3 = msg3;
    }

    public void test(){
        System.out.println("TempDaoFactoryBean");
        System.out.println(msg1+"============"+msg2+"=============="+msg3);
    }
}
