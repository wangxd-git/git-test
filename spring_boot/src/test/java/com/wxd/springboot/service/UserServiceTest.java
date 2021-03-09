package com.wxd.springboot.service;

import com.wxd.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    IUserService service;

    @Test
    void getUserList(){
        List<User> userList = service.getUserList();
        System.out.println("users count="+userList.size());
        for (User users:userList
             ) {
            System.out.println(">>> "+users);
        }
    }
}
