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
@TableName("class_info")
public class ClassInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名称
     */
    @TableField("name")
    private String name;

    /**
     * 邀请码
     */
    @TableField("invite_code")
    private String inviteCode;

    /**
     * 是否启用，0-禁用，1-启用
     */
    @TableField("is_enabled")
    private Integer isEnabled;

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
