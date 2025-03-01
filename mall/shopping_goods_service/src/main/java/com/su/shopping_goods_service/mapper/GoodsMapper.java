package com.su.shopping_goods_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Goods;
import com.su.shopping_common.pojo.GoodsDesc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    //添加商品规格项
    void addGoodsSpecificationOption(@Param("gid") Long gid,@Param("optionId") Long optionId);
    //删除商品规格项
    void deleteGoodsSpecificationOption(Long gid);
    //修改商品上/下架
    void putAway(@Param("id") Long id,@Param("isMarketable")Boolean isMarketable);
    //根据id查询商品
    Goods findById(Long id);
    //查询所有商品详情
    List<GoodsDesc> findAll();
    // 根据id查询商品详情
    GoodsDesc findDesc(Long id);

}
