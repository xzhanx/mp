package com.example.mp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author xzx
 * @date 2020/7/15
 */
@Mapper
public interface TestMybatis {

    @Select("select count(1) from user")
    int testInt();
}
