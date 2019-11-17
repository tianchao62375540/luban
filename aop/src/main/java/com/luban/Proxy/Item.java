package com.luban.Proxy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Auther: tianchao
 * @Date: 2019/11/4 23:11
 * @Description:
 */
@Data
@Accessors(chain = true)
public class Item {
    private Long id;
    private String name;
    private Date insDate;
}
