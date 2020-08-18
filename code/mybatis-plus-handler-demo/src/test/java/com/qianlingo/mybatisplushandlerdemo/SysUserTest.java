package com.qianlingo.mybatisplushandlerdemo;
import java.util.UUID;

import com.qianlingo.mybatisplushandlerdemo.mybatis.domain.sys.SysUser;
import com.qianlingo.mybatisplushandlerdemo.service.sys.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 用户测试类
 *
 * @author qianlingo
 * @date 2020/8/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisPlusHandlerDemoApplication.class)
@Slf4j
public class SysUserTest {

    @Resource
    private ISysUserService iSysUserService;

    @Test
    public void addTest(){
        log.info(" 开始执行 addTest 方法");
        //组装数据
        SysUser sysUser = new SysUser();
        String userId = UUID.randomUUID().toString();
        System.out.println("userId:"+userId);
        sysUser.setUserId(userId);
        sysUser.setUserName("user"+UUID.randomUUID().toString().substring(0,10));
        sysUser.setPassword("qianlingo");
        sysUser.setStatus(1);
        this.iSysUserService.save(sysUser);
        getUserData(userId);
    }

    @Test
    public void updateTest(){
        log.info(" 开始执行 updateTest 方法");
        //组装数据
        SysUser sysUser = this.iSysUserService.getById("c32ad96f-ff9f-4642-968c-89ef0a6fa4e0");
        sysUser.setPassword("qianlingooo");
        this.iSysUserService.updateById(sysUser);
        getUserData(sysUser.getUserId());
    }

    private void getUserData(String userId){
        SysUser sysUser = this.iSysUserService.getById(userId);
        System.out.println(sysUser);
    }
}
