package com.luban.test;

import com.luban.entity.CityEntity;
import com.luban.util.CommUtil;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 20:01
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity().setId("1").setName("test");
        String sql = CommUtil.buildQuerySqlForEntity(cityEntity);
        // select * from city where id = '1' and name = 'test'
        System.out.println(sql);
    }
}
