package com.su.shopping_common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.SeckillGoods;

//秒杀商品服务
public interface SecKillGoodsService {
    //新增秒杀商品
    void add(SeckillGoods seckillGoods);
    //修改秒杀商品（包括修改秒杀结束时间，下架秒杀商品）
    void update(SeckillGoods seckillGoods);
    //分页查询秒杀商品
    Page<SeckillGoods> findPage(int page,int size);
}
