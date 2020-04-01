package com.changgou.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-04-01 17:35
 **/
@FeignClient(value = "seaech")
@RequestMapping("/search")
public interface SkuFeign {
    @GetMapping
    public Map search(@RequestParam(required = false) Map<String,String> searchMap);
}
