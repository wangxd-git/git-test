package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wx.study.demo.Config;
import wx.study.demo.User;

public class TestCase {
    AnnotationConfigApplicationContext acac=null;
    @Before
    public void init(){
        acac=new AnnotationConfigApplicationContext(Config.class);
        System.out.println("init 初始化完成");
    }
    @After
    public void destroy(){
        acac.close();
        System.out.println("acac 以销毁");
    }
    @Test
    public void userTest(){

        User bean = acac.getBean("bean", User.class);
        System.out.println(bean);
    }
}
