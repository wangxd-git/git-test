package com.study.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springboot.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
     public User queryById(int id);

}
