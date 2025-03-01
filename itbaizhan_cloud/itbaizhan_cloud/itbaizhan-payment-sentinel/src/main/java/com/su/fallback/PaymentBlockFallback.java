package com.su.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class PaymentBlockFallback {
    public static String blockHandle(Long id, BlockException e){
        return "服务繁忙，请稍等";
    }
}
