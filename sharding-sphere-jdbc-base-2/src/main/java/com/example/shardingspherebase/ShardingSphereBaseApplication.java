package com.example.shardingspherebase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shardingspherebase.dao")
public class ShardingSphereBaseApplication {

    //shardingSphere provide four ways to config https://shardingsphere.apache.org/document/4.1.0/en/manual/sharding-jdbc/configuration/config-spring-boot/
    //java config
    //yaml config
    //spring boot config
    //spring namespace


    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereBaseApplication.class, args);
    }


}
