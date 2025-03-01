package com.su.shopping_goods_service.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.service.BrandService;
import com.su.shopping_common.pojo.Brand;
import com.su.shopping_common.result.BusException;
import com.su.shopping_common.result.CodeEnum;
import com.su.shopping_goods_service.mapper.BrandMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@DubboService
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand findById(Long id) {
        if (id == 0) {
            int i = 1 / 0;
        }
        if (id == 1) {
            throw new BusException(CodeEnum.PARAMETER);
        }
        return brandMapper.selectById(id);
    }

    @Override
    public List<Brand> findAll() {
        List<Brand> brands = brandMapper.selectList(null);
        return brands;
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateById(brand);
    }

    @Override
    public void delete(Long id) {
        brandMapper.deleteById(id);
    }

    @Override
    public Page<Brand> search(Brand brand, int page, int size) {
        //设置查询条件
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        //如果有查询条件，进行模糊查询
        if(brand != null && StringUtils.hasText(brand.getName())){
            wrapper.like("name",brand.getName());
        }
        //进行分页查询，参数传入 分页条件 和 查询条件
        Page<Brand> page1 = brandMapper.selectPage(new Page<>(page, size), wrapper);
        return page1;
    }

}
