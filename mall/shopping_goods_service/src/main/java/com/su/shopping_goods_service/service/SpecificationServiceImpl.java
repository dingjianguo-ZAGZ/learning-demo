package com.su.shopping_goods_service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Specification;
import com.su.shopping_common.pojo.SpecificationOption;
import com.su.shopping_common.pojo.SpecificationOptions;
import com.su.shopping_common.service.SpecificationService;
import com.su.shopping_goods_service.mapper.SpecificationMapper;
import com.su.shopping_goods_service.mapper.SpecificationOptionMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
@DubboService
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;
    @Override
    public void add(Specification specification) {
        specificationMapper.insert(specification);
    }

    @Override
    public void update(Specification specification) {
        specificationMapper.updateById(specification);
    }

    @Override
    public void delete(Long[] ids) {
        //先删除该规格下所有的规格项
        for (Long id : ids) { //规格id
            //1. 根据规格id删除规格项
            QueryWrapper<SpecificationOption> wrapper = new QueryWrapper();
            wrapper.eq("specId",id);
            specificationOptionMapper.delete(wrapper);
            //删除该规格
            specificationOptionMapper.selectById(id);
        }
    }

    @Override
    public Specification findById(Long id) {
        //调用自定义方法查询
        Specification specification = specificationMapper.findById(id);
        return specification;
    }

    @Override
    public Page<Specification> search(int page, int size) {
        Page<Specification> page1 = specificationMapper.selectPage(new Page<>(page, size), null);
        return page1;
    }

    @Override
    public List<Specification> findByProductTypeId(Long id) {
        return specificationMapper.findByProductTypeId(id);
    }

    @Override
    public void addOption(SpecificationOptions specificationOptions) {
        //获取规格id
        Long specId = specificationOptions.getSpecId();
        //获取规格项名数组
        String[] optionNames = specificationOptions.getOptionName();
        for (String optionName : optionNames) {
            SpecificationOption specificationOption = new SpecificationOption();
            specificationOption.setSpecId(specId);
            specificationOption.setOptionName(optionName);
            //依次插入
            specificationOptionMapper.insert(specificationOption);
        }
    }
    @Override
    public void deleteOption(Long[] ids) {
        specificationOptionMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
