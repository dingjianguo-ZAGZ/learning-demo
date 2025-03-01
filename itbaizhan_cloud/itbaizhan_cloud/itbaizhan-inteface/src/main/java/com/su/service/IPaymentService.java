package com.su.service;

/**
 * 支付接口模块
 */
public interface IPaymentService {
    /**
     * 跟警察订单id支付
     * @param id 订单id
     * @return
     */
    String payment(String id);
}
