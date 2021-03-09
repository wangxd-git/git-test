package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.dto.StudentRegisterDTO;
import cn.com.straw.portal.ex.ClassDisabledException;
import cn.com.straw.portal.ex.InsertException;
import cn.com.straw.portal.ex.InviteCodeException;
import cn.com.straw.portal.ex.PhoneDuplicateException;
import cn.com.straw.portal.mapper.ClassInfoMapper;
import cn.com.straw.portal.model.ClassInfo;
import cn.com.straw.portal.model.User;
import cn.com.straw.portal.mapper.UserMapper;
import cn.com.straw.portal.service.IUserService;
import cn.com.straw.portal.util.PasswordUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
   @Autowired
   ClassInfoMapper classInfoMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void registerStudent(StudentRegisterDTO studentRegisterDTO) {
      // 基于参数inviteCode调用classInfoMapper.findByInviteCode()执行查询
        ClassInfo byInviteCode = classInfoMapper.findByInviteCode(studentRegisterDTO.getInviteCode());
        // 判断查询结果邀请码是否为null
        if(byInviteCode == null){
            // 是：抛出InviteCodeException
            throw new InviteCodeException();
        }
      // 判断以上查询结果中的isEnabled是否为0
        if(byInviteCode.getIsEnabled() == 0){
            throw new ClassDisabledException();
        }

        User byPhone = userMapper.findByPhone(studentRegisterDTO.getPhone());
        if(byPhone != null){
            throw new PhoneDuplicateException();
        }

        // 创建当前时间对象now
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
// 补全user对象的属性值：nickName < 参数nickName
        user.setNickName(studentRegisterDTO.getNickName());
// 补全user对象的属性值：password < 参数password
        String password=studentRegisterDTO.getPassword();
        String rawPassword = PasswordUtils.encode(password);
        user.setPassword(rawPassword);
// 补全user对象的属性值：phone < 参数phone
        user.setPhone(studentRegisterDTO.getPhone());
// 补全user对象的属性值：classId < 此前的查询结果
        user.setClassId(byInviteCode.getId());
// 补全user对象的属性值：isEnabled < 1
        user.setIsEnabled(1);
// 补全user对象的属性值：isLocked < 0
        user.setIsLocked(0);
// 补全user对象的属性值：accountType < 0
        user.setAccountType(0);
// 补全user对象的属性值：gmtCreate < now
        user.setGmtCreate(now);
// 补全user对象的属性值：gmtModified < now
        user.setGmtModified(now);
// 基于以上user对象调用userMapper.insert()执行插入数据，并获取返的“受影响行数”

        int rows = userMapper.insert(user);

        // 判断以上返回的“受影响行数”是否不为1
        if (rows != 1) {
       // 是：抛出InsertException
            throw new InsertException();
        }else {
            log.info("注册成功----"+rows);
        }
    }
}
