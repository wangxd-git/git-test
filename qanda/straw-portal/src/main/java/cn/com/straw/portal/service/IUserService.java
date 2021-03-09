package cn.com.straw.portal.service;

import cn.com.straw.portal.dto.StudentRegisterDTO;
import cn.com.straw.portal.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
public interface IUserService extends IService<User> {
    void registerStudent(StudentRegisterDTO studentRegisterDTO);

}
