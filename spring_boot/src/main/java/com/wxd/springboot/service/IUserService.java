package com.wxd.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxd.springboot.model.User;

import java.util.List;

public interface IUserService {

     List<User> getUserList();
}
