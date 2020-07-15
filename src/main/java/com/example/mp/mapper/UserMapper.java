package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mp.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xzx
 * @since 2020/5/29
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select id, name, age, email from user")
    IPage<User> selectPage(Page<User> page);

    @Select("select * from user where id in (#{ids})")
    List<User> testIn(@Param("ids") List<Integer> ids);

    @Select("select * from user where name in (#{names})")
    List<User> testInString(@Param("names") List<String> names);
}
