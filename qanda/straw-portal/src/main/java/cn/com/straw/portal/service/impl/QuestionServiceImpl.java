package cn.com.straw.portal.service.impl;

import cn.com.straw.portal.model.Question;
import cn.com.straw.portal.mapper.QuestionMapper;
import cn.com.straw.portal.service.IQuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
