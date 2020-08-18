package com.qianlingo.mybatisplushandlerdemo.service.sys.impl;

import com.qianlingo.mybatisplushandlerdemo.mybatis.domain.sys.SysUser;
import com.qianlingo.mybatisplushandlerdemo.mybatis.mapper.sys.SysUserMapper;
import com.qianlingo.mybatisplushandlerdemo.service.sys.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户数据表 服务实现类
 * </p>
 *
 * @author qianlingo
 * @since 2020-08-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
