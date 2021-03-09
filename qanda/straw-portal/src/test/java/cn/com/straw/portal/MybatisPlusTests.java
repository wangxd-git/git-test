package cn.com.straw.portal;

import cn.com.straw.portal.mapper.UserMapper;
import cn.com.straw.portal.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MybatisPlusTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void insert(){
        User user=new User();
        user.setUsername("李老师");
        user.setPassword("6666");
        user.setPhone("13621352180");
        int rows=userMapper.insert(user);
        System.out.println("rows= "+rows);

    }

   @Test
    void selectById(){
        Integer id=9;
       User user = userMapper.selectById(id);
       System.out.println("查询成功："+user);
   }

   @Test
    void updateById(){
       User user=new User();
       user.setId(10);
       user.setNickName("怪兽终结者");
       int rows=userMapper.updateById(user);
       log.info("修改成功："+rows);
   }

   @Test
    void deleteById(){
        Integer id=9;
        int rows=userMapper.deleteById(id);
       System.out.println("删除成功："+rows);
   }

   @Test
    void seleceAll(){
       QueryWrapper<User> queryWrapper=new QueryWrapper<>();
       queryWrapper.gt("id",2);
       List<User> users = userMapper.selectList(queryWrapper);
       for (User user:users
            ) {
           System.out.println("---->>>"+user);
       }
   }
}
