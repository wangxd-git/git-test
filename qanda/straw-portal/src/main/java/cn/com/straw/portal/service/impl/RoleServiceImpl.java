package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.Role;
import cn.com.straw.portal.mapper.RoleMapper;
import cn.com.straw.portal.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
