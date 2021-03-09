package cn.com.straw.portal.service;

import cn.com.straw.portal.dto.StudentRegisterDTO;
import cn.com.straw.portal.ex.ClassDisabledException;
import cn.com.straw.portal.ex.InsertException;
import cn.com.straw.portal.ex.InviteCodeException;
import cn.com.straw.portal.ex.PhoneDuplicateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTests {
    @Autowired
    IUserService service;

    @Test
    void registerStudent() {
        try {
            StudentRegisterDTO student = new StudentRegisterDTO();
            student.setInviteCode("jsd2020-706246");
            student.setNickName("蜡笔小新");
            student.setPassword("1234");
            student.setPhone("15633144420");
            service.registerStudent(student);
            log.info("注册成功！");
        } catch (InviteCodeException e) {
           log.error("注册失败！邀请码错误！");
        } catch (ClassDisabledException e) {
           log.error("注册失败！班级已经被禁用！");
        } catch (PhoneDuplicateException e) {
            log.error("注册失败！手机号码已经被注册！");
        } catch (InsertException e) {
            log.error("注册失败！服务器忙，请稍后再次尝试！");
        }
    }
}
