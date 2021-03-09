package cn.com.straw.portal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，学生注册时，使用手机号码作为用户名
     */
    @TableField("username")
    private String username;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 性别，0-女，1-男
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 生日
     */
    @TableField("day_of_birth")
    private LocalDate dayOfBirth;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Integer classId;

    /**
     * 是否启用，0-禁用，1-启用
     */
    @TableField("is_enabled")
    private Integer isEnabled;

    /**
     * 是否已锁定，0-未锁定，1-已锁定
     */
    @TableField("is_locked")
    private Integer isLocked;

    /**
     * 账号类型，0-学生，1-老师
     */
    @TableField("account_type")
    private Integer accountType;

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
