package com.luban.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * mybatis应用
 * @Auther: tianchao
 * @Date: 2019/12/6 23:34
 * @Description:
 */
public interface CardDao {
    @Select("select * from card where card_number like '%${number}%'")
    List<Map<String,String>> list(@Param("number") String number);
}
