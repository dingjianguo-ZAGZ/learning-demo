package com.su.shopping_common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Goods;
import com.su.shopping_common.pojo.GoodsDesc;
import org.bouncycastle.jcajce.provider.symmetric.DES;

import java.util.List;

//商品服务
public interface GoodsService {
    //新增商品
    void add(Goods goods);
    //修改商品
    void update(Goods goods);
    //根据id查询商品详情
    Goods findById(Long id);
    //下架/上架商品
    void putAway(Long id,Boolean isMarketable);
    //分页查询商品
    Page<Goods> search(Goods goods,int page,int size);
    //查询所有商品详情
    List<GoodsDesc> findAll();
    //跟据id查询商品详情（从数据库中查询）
    GoodsDesc findDesc(Long id);
}
