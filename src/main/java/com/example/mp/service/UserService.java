package com.example.mp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mp.mapper.UserMapper;
import com.example.mp.model.User;
import org.springframework.stereotype.Service;

/**
 * @author xzx
 * @since 2020/5/29
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public IPage<User> selectPage(Page<User> page) {
        return this.baseMapper.selectPage(page);
    }
}
