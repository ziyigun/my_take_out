package com.ali.my_take_out;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@ServletComponentScan
@Slf4j
@EnableTransactionManagement
@EnableCaching //开启SpringCache缓存
    public class MyTakeOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTakeOutApplication.class, args);
        log.info("项目启动成功...");
    }

}
