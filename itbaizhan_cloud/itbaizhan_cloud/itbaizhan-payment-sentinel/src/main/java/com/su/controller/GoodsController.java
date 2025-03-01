package com.su.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
    @SentinelResource("/hot")
    @GetMapping("/getGoods")
    public String getGoods(String goodsName){
        return goodsName;
    }
}
