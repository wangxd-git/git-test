package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.Comment;
import cn.com.straw.portal.mapper.CommentMapper;
import cn.com.straw.portal.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
