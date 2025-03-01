package com.su.shopping_goods_service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.*;
import com.su.shopping_common.service.GoodsService;
import com.su.shopping_common.service.SearchService;
import com.su.shopping_goods_service.mapper.GoodsImageMapper;
import com.su.shopping_goods_service.mapper.GoodsMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务
 */
@DubboService
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsImageMapper goodsImageMapper;
    @DubboReference
    private SearchService searchService;

    @Override
    public void add(Goods goods) {
        //插入商品数据
        goodsMapper.insert(goods);
        //插入图片数据
        //获取商品主键(通过mybatis-plus将商品数据插入数据库之后，会自动为该商品数据生成主键)
        Long gid = goods.getId();
        List<GoodsImage> images = goods.getImages();
        for (GoodsImage image : images) {
            //为图片设置商品id
            image.setGoodsId(gid);
            goodsImageMapper.insert(image);
        }
        //插入商品规格数据
        //获取商品规格
        List<Specification> specifications = goods.getSpecifications();
        //获取商品规格项
        List<SpecificationOption> options = new ArrayList<>();
        //遍历规格，获取所有的规格项
        for (Specification specification : specifications) {
            List<SpecificationOption> specificationOptions = specification.getSpecificationOptions();
            //将集合中的每一天数据插入options
            options.addAll(specificationOptions);
        }
        //遍历规格项，插入商品——规格项表
        for (SpecificationOption option : options) {
            goodsMapper.addGoodsSpecificationOption(gid, option.getId());
        }
        //将数据同步到ES中
        GoodsDesc desc = goodsMapper.findDesc(gid);
        searchService.syncGoodsToES(desc);
    }

    @Override
    public void update(Goods goods) {
        //删除图片数据
        //获取商品主键(通过mybatis-plus将商品数据插入数据库之后，会自动为该商品数据生成主键)
        Long gid = goods.getId();
        QueryWrapper<GoodsImage> wrapper = new QueryWrapper<>();
        wrapper.eq("goodsId", gid);
        goodsImageMapper.delete(wrapper);
        //删除规格项数据
        goodsMapper.deleteGoodsSpecificationOption(gid);
        //插入新数据
        //插入商品数据
        goodsMapper.updateById(goods);
        //插入图片数据
        List<GoodsImage> images = goods.getImages();
        for (GoodsImage image : images) {
            //为图片设置商品id
            image.setGoodsId(gid);
            goodsImageMapper.insert(image);
        }
        //插入商品规格数据
        //获取商品规格
        List<Specification> specifications = goods.getSpecifications();
        //获取商品规格项
        List<SpecificationOption> options = new ArrayList<>();
        //遍历规格，获取所有的规格项
        for (Specification specification : specifications) {
            List<SpecificationOption> specificationOptions = specification.getSpecificationOptions();
            //将集合中的每一天数据插入options
            options.addAll(specificationOptions);
        }
        //遍历规格项，插入商品——规格项表
        for (SpecificationOption option : options) {
            goodsMapper.addGoodsSpecificationOption(gid, option.getId());
        }
        //将数据同步到ES中
        GoodsDesc desc = goodsMapper.findDesc(gid);
        searchService.syncGoodsToES(desc);
    }

    @Override
    public Goods findById(Long id) {
        return goodsMapper.findById(id);

    }

    @Override
    public void putAway(Long id, Boolean isMarketable) {
        goodsMapper.putAway(id, isMarketable);
        //上架-同步，下架-删除
        if(isMarketable){
            //将数据同步到ES中
            GoodsDesc desc = goodsMapper.findDesc(id);
            searchService.syncGoodsToES(desc);
        }else {
            searchService.delete(id);
        }
    }

    @Override
    public Page<Goods> search(Goods goods, int page, int size) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        if (goods != null && StringUtils.hasText(goods.getGoodsName())) {
            wrapper.like("goodsName", goods.getGoodsName());
        }
        Page<Goods> page1 = goodsMapper.selectPage(new Page<>(page, size), wrapper);
        return page1;
    }

    @Override
    public List<GoodsDesc> findAll() {
        return goodsMapper.findAll();
    }

    public interface GoodsService {
        // 查询商品详情
        GoodsDesc findDesc(Long id);
    }
    @Override
    public GoodsDesc findDesc(Long id) {
        return goodsMapper.findDesc(id);
    }


}
