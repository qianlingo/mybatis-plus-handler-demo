package com.qianlingo.mybatisplushandlerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 * @author qianlingo
 * @date 2020/08/18
 */
@MapperScan("com.qianlingo.mybatisplushandlerdemo.mybatis.mapper")
@SpringBootApplication
public class MybatisPlusHandlerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusHandlerDemoApplication.class, args);
    }

}
