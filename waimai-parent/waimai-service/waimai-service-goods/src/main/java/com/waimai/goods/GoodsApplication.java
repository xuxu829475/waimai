package com.waimai.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-03-30 14:38
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.waimai.goods.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
