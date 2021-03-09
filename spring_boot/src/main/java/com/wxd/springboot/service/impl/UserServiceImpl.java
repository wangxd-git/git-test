package com.wxd.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxd.springboot.mapper.UserMapper;
import com.wxd.springboot.model.User;
import com.wxd.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUserList() {

        return userMapper.queryUser();
    }
}
