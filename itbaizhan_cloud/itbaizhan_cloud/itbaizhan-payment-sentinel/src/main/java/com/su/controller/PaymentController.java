package com.su.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.su.fallback.PaymentBlockFallback;
import com.su.fallback.PaymentFallback;
import com.su.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sentinel控制类
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/testA")
    public String testA(){
        return "testA";
    }
    @GetMapping("/testC")
    public String testC(Integer id){
        if(id == 1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "testC";
    }

    @GetMapping("/testD")
    public String testD(Integer id){
        if(id == 1){
            throw new RuntimeException("故意抛出异常，出发异常比例熔断");
        }
        return "testD";
    }

    @GetMapping("/testF")
    public String testF(Integer id){
        System.out.println(10/0);
        return "testF";
    }
    @GetMapping("/query")
    public String query(){
        String s = goodsService.queryGoods();
        return "订单内容";
    }
    @GetMapping("/save")
    public String save(){
        String s = goodsService.queryGoods();
        return "添加订单";
    }
    @GetMapping("/update")
    public String update(){
        return "更新订单";
    }
    @GetMapping("/warmup")
    public String warmup(){
        return "预热";
    }

    /**
     * 内置 fallback
     * @param id
     * @return
     *//*
    @SentinelResource(value = "testFallBack",fallback = "testFallBack")
    @GetMapping("/payment/findById")
    public String findById(Long id){
        if(id == 1){
            throw new RuntimeException("出异常了");
        }
        return "支付信息";
    }*/
    @SentinelResource(value = "findById",fallbackClass = PaymentFallback.class,fallback = "findById")
    @GetMapping("/payment/findById")
    public String findById(Long id){
        if(id == 1){
            throw new RuntimeException("出异常了");
        }
        return "支付信息";
    }

    /**
     * 内置
     * @param id
     * @return
     *//*
    @SentinelResource(value = "block",blockHandler = "blockHandle")
    @GetMapping("/block")
    public String block(Long id){
        if(id == 1){
            System.out.println(10/0);
        }
        return "block";
    }*/
    /**
     * 外置
     * @param id
     * @return
     */
    @SentinelResource(value = "block",blockHandlerClass = PaymentBlockFallback.class,blockHandler = "blockHandle")
    @GetMapping("/block")
    public String block(Long id){
        if(id == 1){
            System.out.println(10/0);
        }
        return "block";
    }

    /**
     * sentinel熔断异常
     * @param id
     * @return
     */
    public String blockHandle(Long id, BlockException e){
        return "服务繁忙，请稍等";
    }

}
