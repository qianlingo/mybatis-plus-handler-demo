package com.qianlingo.mybatisplushandlerdemo.mybatis.domain.sys;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户数据表
 * </p>
 *
 * @author qianlingo
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码(demo项目，明文录入)
     */
    private String password;

    /**
     * 状态(0:禁用,1:启用)
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建人编号
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserId;

    /**
     * 修改人编号
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;


}
