package cn.com.straw.portal.mapper;

import cn.com.straw.portal.model.ClassInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ClassInfoMapperTests {

    @Autowired
    ClassInfoMapper mapper;

    @Test
    void findByInviteCode(){
        String inviteCode = "jsd2021-876840";
        ClassInfo classInfo = mapper.findByInviteCode(inviteCode);
        log.info("ClassInfo >>> " + classInfo);
    }
}
