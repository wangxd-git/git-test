package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.Tag;
import cn.com.straw.portal.mapper.TagMapper;
import cn.com.straw.portal.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
