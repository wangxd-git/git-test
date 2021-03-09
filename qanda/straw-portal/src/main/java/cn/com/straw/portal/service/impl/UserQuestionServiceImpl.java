package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.UserQuestion;
import cn.com.straw.portal.mapper.UserQuestionMapper;
import cn.com.straw.portal.service.IUserQuestionService;
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
public class UserQuestionServiceImpl extends ServiceImpl<UserQuestionMapper, UserQuestion> implements IUserQuestionService {

}
