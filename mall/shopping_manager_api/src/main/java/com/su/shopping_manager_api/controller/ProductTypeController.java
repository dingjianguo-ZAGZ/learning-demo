package com.su.shopping_manager_api.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.ProductType;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.ProductTypeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {
    @DubboReference
    private ProductTypeService productTypeService;

    /**
     * 新增产品类型
     * @param productType
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody ProductType productType){
        productTypeService.add(productType);
        return BaseResult.ok();
    }
    /**
     * 修改产品类型
     * @param productType
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody ProductType productType){
        productTypeService.update(productType);
        return BaseResult.ok();
    }
    /**
     * 删除产品类型
     * @param id
     */
    @PutMapping("/delete")
    public BaseResult delete(Long id){
        productTypeService.delete(id);
        return BaseResult.ok();
    }

    /**
     * 根据id查询产品类型
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public BaseResult<ProductType> findById(Long id){
        ProductType productType = productTypeService.findById(id);
        return BaseResult.ok(productType);
    }

    /**
     * 分页查询产品类型
     * @param productType
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search")
    public BaseResult<Page<ProductType>> search(ProductType productType,int page,int size){
        Page<ProductType> page1 = productTypeService.search(productType, page, size);
        return BaseResult.ok(page1);
    }

    /**
     * 根据条件查询商品类型列表
     * @param productType
     * @return
     */
    @GetMapping("/findProductType")
    public BaseResult<List<ProductType>> findProductType(ProductType productType){
        List<ProductType> list = productTypeService.findProductType(productType);
        return BaseResult.ok(list);
    }

    /**
     * 根据父类型id查询商品类型列表
     * @param parentId
     * @return
     */
    @GetMapping("/findByParentId")
    public BaseResult<List<ProductType>> findByParentId(Long parentId){
        //构建查询条件对象
        ProductType productType = new ProductType();
        productType.setParentId(parentId);
        List<ProductType> list = productTypeService.findProductType(productType);
        return BaseResult.ok(list);
    }

}
