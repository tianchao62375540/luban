package com.luban.entity;

import com.luban.anno.MyEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: tianchao
 * @Date: 2019/10/25 19:58
 * @Description:
 */

@MyEntity(value = "city")
@Data
@Accessors(chain = true)
public class CityEntity {
    private String id;
    private String name;
}
