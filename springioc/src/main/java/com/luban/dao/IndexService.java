package com.luban.dao;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Auther: tianchao
 * @Date: 2019/10/23 20:00
 * @Description:
 */
@Service(value = "service")
public class IndexService implements ApplicationContextAware {
    ApplicationContext context;
    private IndexDao dao = null;

    public IndexService() {

    }

    public IndexService(IndexDao dao) {
        this.dao = dao;
    }

    public IndexDao getDao() {
        return dao;
    }

    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

    public void test(){
        this.dao = (IndexDao)context.getBean("dao");
        System.out.println(dao);
        dao.test();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context  =applicationContext;
    }
}
