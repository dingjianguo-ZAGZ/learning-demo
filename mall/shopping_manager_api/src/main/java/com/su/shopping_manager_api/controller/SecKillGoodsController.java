package com.su.shopping_manager_api.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.SeckillGoods;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.SecKillGoodsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 商品秒杀
 */
@RestController
@RequestMapping("/seckillGoods")
public class SecKillGoodsController {
    @DubboReference
    private SecKillGoodsService secKillGoodsService;

    /**
     * 新增秒杀商品
     * @param seckillGoods
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody SeckillGoods seckillGoods){
        secKillGoodsService.add(seckillGoods);
        return BaseResult.ok();
    }

    /**
     * 修改秒杀商品
     * @param seckillGoods
     * @return
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody SeckillGoods seckillGoods){
        secKillGoodsService.update(seckillGoods);
        return BaseResult.ok();
    }

    /**
     * 查询秒杀商品
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findPage")
    public BaseResult<Page<SeckillGoods>> findPage(int page,int size){
        Page<SeckillGoods> page1 = secKillGoodsService.findPage(page, size);
        return BaseResult.ok(page1);
    }
}
