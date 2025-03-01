package com.su.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @SentinelResource("/goods")
    public String queryGoods(){
        return "商品信息";
    }
}
