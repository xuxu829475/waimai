package com.waimai.goods.feign;

import com.waimai.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-04-01 12:35
 **/
@FeignClient(value = "goods")
@RequestMapping("/sku")
public interface SkuFeign {
    @GetMapping("/spu/{spuId}")
    List<Sku> findSkuListBySpuId(@PathVariable("spuId") String all);
}
