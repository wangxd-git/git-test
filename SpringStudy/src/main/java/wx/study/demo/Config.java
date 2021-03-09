package wx.study.demo;

import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public User bean(){
        User user=new User();
        user.setName("wangxiaodong");
        user.setAge(100);
        user.setStudy("学习java");
        return user;
    }
}
