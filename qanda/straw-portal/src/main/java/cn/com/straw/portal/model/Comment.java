package cn.com.straw.portal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tedu.cn
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作者id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 作者昵称
     */
    @TableField("user_nick_name")
    private String userNickName;

    /**
     * 答案id
     */
    @TableField("answer_id")
    private Integer answerId;

    /**
     * 正文
     */
    @TableField("content")
    private String content;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;


}
