package com.su.shopping_goods_service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.SeckillGoods;
import com.su.shopping_common.service.SecKillGoodsService;
import com.su.shopping_goods_service.mapper.SecKillGoodsMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

@DubboService
@Transactional
public class SeckillGoodsServiceImpl implements SecKillGoodsService {
    @Autowired
    private SecKillGoodsMapper secKillGoodsMapper;
    @Override
    public void add(SeckillGoods seckillGoods) {
        secKillGoodsMapper.insert(seckillGoods);
    }

    @Override
    public void update(SeckillGoods seckillGoods) {
        secKillGoodsMapper.updateById(seckillGoods);
    }

    @Override
    public Page<SeckillGoods> findPage(int page, int size) {
        Page<SeckillGoods> page1 = secKillGoodsMapper.selectPage(new Page<>(page, size), null);
        return page1;
    }
}
