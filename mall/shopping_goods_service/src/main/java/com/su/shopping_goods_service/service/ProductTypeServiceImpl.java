package com.su.shopping_goods_service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.ProductType;
import com.su.shopping_common.result.BusException;
import com.su.shopping_common.result.CodeEnum;
import com.su.shopping_common.service.ProductTypeService;
import com.su.shopping_goods_service.mapper.ProductTypeMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
@DubboService
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public void add(ProductType productType) {
        //根据父类型id查询父类型
        ProductType productParent = productTypeMapper.selectById(productType.getParentId());
        if(productParent == null){
            //如果没有父类型，则为一级
            productType.setLevel(1);
        }else if (productParent.getLevel() < 3){
            //父类型级别小于3，当前级别为父类型+1
            productType.setLevel(productParent.getLevel() + 1);
        }else if (productParent.getLevel() == 3){
            //父类型级别等于3，不能添加子级别
            throw new BusException(CodeEnum.INSERT_PRODUCT_TYPE_ERROR);
        }
        productTypeMapper.insert(productType);
    }

    @Override
    public void update(ProductType productType) {
        //根据父类型id查询父类型
        ProductType productParent = productTypeMapper.selectById(productType.getParentId());
        if(productParent == null){
            //如果没有父类型，则为一级
            productType.setLevel(1);
        }else if (productParent.getLevel() < 3){
            //父类型级别小于3，当前级别为父类型+1
            productType.setLevel(productParent.getLevel() + 1);
        }else if (productParent.getLevel() == 3){
            //父类型级别等于3，不能添加子级别
            throw new BusException(CodeEnum.INSERT_PRODUCT_TYPE_ERROR);
        }
        productTypeMapper.updateById(productType);
    }

    @Override
    public void delete(Long id) {
        //如果该商品类型有子类型，不能删除
        //1.查询该类型的子类型
        QueryWrapper<ProductType> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId",id);
        //根据父类型的id查询 ， 父类型的id是当前类型的id
        List<ProductType> productTypes = productTypeMapper.selectList(wrapper);
        if(!CollectionUtils.isEmpty(productTypes)){
            throw new BusException(CodeEnum.DELETE_PRODUCT_ERROR);
        }
        productTypeMapper.deleteById(id);
    }

    @Override
    public ProductType findById(Long id) {
        ProductType productType = productTypeMapper.selectById(id);
        return productType;
    }

    @Override
    public Page<ProductType> search(ProductType productType, int page, int size) {
        QueryWrapper<ProductType> wrapper = new QueryWrapper();
        if(productType != null){
            //判断是否有类型名
            if(StringUtils.hasText(productType.getName())){
                wrapper.like("name",productType.getName());
            }
            //判断上级类型id是否为空
            if(productType.getParentId() != null){
                wrapper.eq("parentId",productType.getParentId());
            }
        }
        //进行分页查询
        Page<ProductType> page1 = productTypeMapper.selectPage(new Page<>(page, size), wrapper);
        return page1;
    }

    @Override
    public List<ProductType> findProductType(ProductType productType) {
        QueryWrapper<ProductType> wrapper = new QueryWrapper();
        if(productType != null){
            //判断是否有类型名
            if(StringUtils.hasText(productType.getName())){
                wrapper.like("name",productType.getName());
            }
            //判断上级类型id是否为空
            if(productType.getParentId() != null){
                wrapper.eq("parentId",productType.getParentId());
            }
        }
        List<ProductType> productTypes = productTypeMapper.selectList(wrapper);
        return productTypes;
    }
}
