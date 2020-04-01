package com.waimai.search.controller;

import com.changgou.search.feign.SkuFeign;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-04-01 17:42
 **/
@Controller
@RequestMapping("/search")
public class SkuController {

    @Resource
    private SkuFeign skuFeign;

    @GetMapping("/list")
    public String search(@RequestParam(required = false) Map<String,String> searchMap, Model model){
        Map search = skuFeign.search(searchMap);
        model.addAttribute("result", model);
        return "search";
    }
}
