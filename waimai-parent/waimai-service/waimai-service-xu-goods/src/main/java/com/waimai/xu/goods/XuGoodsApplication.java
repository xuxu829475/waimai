package com.waimai.xu.goods;

import entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-03-31 21:10
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.waimai.xu.goods.dao"})
public class XuGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(XuGoodsApplication.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0);
    }
}
