package com.wxd.springboot.mapper;

import com.wxd.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void find(){
        List<User> users = mapper.queryUser();
        System.out.print("Users="+users);
    }

}
