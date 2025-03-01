package com.su.fallback;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentFallback {
    /**
     * 降级方法
     * @param id
     * @param e
     * @return
     */
    public static String findById(Long id,Throwable e){//接受异常
        return "服务繁忙，请稍等";
    }
}
