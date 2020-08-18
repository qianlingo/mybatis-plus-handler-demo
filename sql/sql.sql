create table data_classroom
(
    id             int auto_increment comment '编号',
    name           varchar(100) charset utf8 not null comment '教室名称',
    status         int default 1             not null comment '状态(0:禁用,1:启用)',
    create_time    datetime                  null comment '创建时间',
    update_time    datetime                  null comment '修改时间',
    create_user_id varchar(36)               not null comment '创建人编号',
    update_user_id varchar(36)               not null comment '修改人编号',
    constraint classroom_pk
        unique (id)
)
    comment '教室数据表';

create table sys_user
(
    user_id        varchar(36)   not null comment '用户编号'
        primary key,
    user_name      varchar(36)   not null comment '用户名称',
    password       varchar(36)   not null comment '密码(demo项目，明文录入)',
    status         int default 1 not null comment '状态(0:禁用,1:启用)',
    create_time    datetime      null comment '创建时间',
    update_time    datetime      null comment '修改时间',
    create_user_id varchar(36)   null comment '创建人编号',
    update_user_id varchar(36)   null comment '修改人编号'
) comment '用户数据表';