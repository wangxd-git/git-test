package cn.com.straw.portal.mapper;

import cn.com.straw.portal.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User findByPhone(String phone);
}
