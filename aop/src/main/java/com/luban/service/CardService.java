package com.luban.service;

import com.luban.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Auther: tianchao
 * @Date: 2019/12/6 23:51
 * @Description:
 */
@Component
public class CardService {
    @Autowired
    CardDao cardDao;
    public void list(){
        List<Map<String, String>> eee = cardDao.list("eee");
        /*for (Map<String, String> integerStringMap : eee) {
            for (String integer : integerStringMap.keySet()) {
                System.out.println(integer);
                System.out.println(integerStringMap.get(integer));
            }
        }*/
        System.out.println(eee);

    }
}
