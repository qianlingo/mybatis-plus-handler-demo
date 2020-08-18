package com.qianlingo.mybatisplushandlerdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * MetaObjectHandler
 * <p>
 * 官方注释：
 * 元对象字段填充控制器抽象类，实现公共字段自动写入
 * 所有入参的 MetaObject 必定是 entity 或其子类的 MetaObject
 * </p>
 * @author qianlingo
 * @date 2020/8/18
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 管理员用户编号
     */
    private final String ADMIN_USER_ID = "a15b6c54-e137-11ea-97ee-0242ac110002";

    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     * 需字段加入
     * 注解: TableField(fill = FieldFill.INSERT)
     * or
     * 注解: TableField(fill = FieldFill.INSERT_UPDATE)
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //填充create_time字段公用数据
        if (metaObject.hasGetter("createTime") && metaObject.hasGetter("createTime")) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        //填充 createUserId 字段公用数据
        if (metaObject.hasGetter("createUserId") && metaObject.hasGetter("createUserId")) {
            setFieldValByName("createUserId", ADMIN_USER_ID, metaObject);
        }
        //填充 updateTime 字段公用数据
        if (metaObject.hasGetter("updateTime") && metaObject.hasGetter("updateTime")) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
        //填充 updateUserId 字段公用数据
        if (metaObject.hasGetter("updateUserId") && metaObject.hasGetter("updateUserId")) {
            setFieldValByName("updateUserId", ADMIN_USER_ID, metaObject);
        }
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     * 需字段加入
     * 注解: TableField(fill = FieldFill.UPDATE)
     * or
     * 注解: TableField(fill = FieldFill.INSERT_UPDATE)
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //填充 updateTime 字段公用数据
        if (metaObject.hasGetter("updateTime") && metaObject.hasGetter("updateTime")) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
        //填充 updateUserId 字段公用数据
        if (metaObject.hasGetter("updateUserId") && metaObject.hasGetter("updateUserId")) {
            setFieldValByName("updateUserId", ADMIN_USER_ID, metaObject);
        }
    }
}
