package com.su.shopping_goods_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Specification;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpecificationMapper extends BaseMapper<Specification> {
    //查询商品规格时，将该规格的规格项一并查出来
    Specification findById(Long id);
    List<Specification> findByProductTypeId(Long productTypeId);
}
