package com.study.springboot.springboot.mapper;

import com.study.springboot.mapper.UserMapper;
import com.study.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void findById(){
        int id=1;
        User user = mapper.queryById(id);
        System.out.println("User="+user);
    }
}
