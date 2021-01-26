package com.aloogn.project;

import com.aloogn.project.config.UniqueNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zouXiaoLong on 2021/1/15 11:50
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(nameGenerator = UniqueNameGenerator.class)
@EnableFeignClients
@EnableHystrix
public class AppApiMain {
    public static void main(String[] args) {
        SpringApplication.run(AppApiMain.class,args);
    }
}
