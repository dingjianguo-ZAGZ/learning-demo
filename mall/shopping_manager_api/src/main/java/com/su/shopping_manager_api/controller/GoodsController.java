package com.su.shopping_manager_api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Goods;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.GoodsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @DubboReference
    private GoodsService goodsService;

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @PostMapping("add")
    public BaseResult add(@RequestBody Goods goods){
        goodsService.add(goods);
        return BaseResult.ok();
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @PutMapping("update")
    public BaseResult update(@RequestBody Goods goods){
        goodsService.update(goods);
        return BaseResult.ok();
    }

    /**
     * 上下架商品
     * @param id
     * @param isMarketable
     * @return
     */
    @PutMapping("/putAway")
    public BaseResult putAway(Long id,Boolean isMarketable){
        goodsService.putAway(id,isMarketable);
        return BaseResult.ok();
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @GetMapping("findById")
    public BaseResult<Goods> findById(Long id){
        Goods goods = goodsService.findById(id);
        return BaseResult.ok(goods);
    }

    /**
     * 分页查询商品
     * @param goods
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search")
    public BaseResult<Page<Goods>> search(Goods goods,int page,int size){
        Page<Goods> page1 = goodsService.search(goods, page, size);
        return BaseResult.ok(page1);
    }
}
