package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.Permission;
import cn.com.straw.portal.mapper.PermissionMapper;
import cn.com.straw.portal.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
