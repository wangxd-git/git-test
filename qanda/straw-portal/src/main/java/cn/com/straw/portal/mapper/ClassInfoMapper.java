package cn.com.straw.portal.mapper;

import cn.com.straw.portal.model.ClassInfo;
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
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {

    ClassInfo findByInviteCode(String inviteCode);
}
