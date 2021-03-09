package cn.com.straw.portal.mapper;

import cn.com.straw.portal.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userMapperTests {

    @Autowired
    UserMapper mapper;

    @Test
    void findByPhone() {
        String phone = "13621352179";
        User user = mapper.findByPhone(phone);
        System.out.println("User = " + user);
    }


}
