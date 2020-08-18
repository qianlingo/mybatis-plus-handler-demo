package com.qianlingo.mybatisplushandlerdemo.mybatis.domain.data;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教室数据表
 * </p>
 *
 * @author qianlingo
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataClassroom implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 教室名称
     */
    private String name;

    /**
     * 状态(0:禁用,1:启用)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人编号
     */
    private String createUserId;

    /**
     * 修改人编号
     */
    private String updateUserId;


}
