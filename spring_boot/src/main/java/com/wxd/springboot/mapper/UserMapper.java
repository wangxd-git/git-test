package com.wxd.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxd.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User queryById(int id);
    List<User> queryUser();

}
