package com.su.shopping_manager_api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Brand;

import com.su.shopping_common.result.BaseResult;


import com.su.shopping_common.service.BrandService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @DubboReference
    private BrandService brandService;

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public BaseResult<Brand> findById(Long id){
        Brand brand = brandService.findById(id);
        return BaseResult.ok(brand);
    }

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping("/all")
    public BaseResult<List<Brand>> findAll(){
        List<Brand> all = brandService.findAll();
        return BaseResult.ok(all);
    }

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody Brand brand){
        brandService.add(brand);
        return BaseResult.ok();
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody Brand brand){
        brandService.update(brand);
        return BaseResult.ok();
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public BaseResult delete(Long id){
        brandService.delete(id);
        return BaseResult.ok();
    }
    @GetMapping("/search")
    public BaseResult<Page<Brand>> search(Brand brand,int page,int size){
        //此时是一个get请求，参数在url路径中，不用加@requsetBody注解
        Page<Brand> page1 = brandService.search(brand, page, size);
        return BaseResult.ok(page1);
    }
}
