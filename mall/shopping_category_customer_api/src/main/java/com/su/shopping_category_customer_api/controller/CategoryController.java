package com.su.shopping_category_customer_api.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Category;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.CategoryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/category")
public class CategoryController {
    @DubboReference
    private CategoryService categoryService;
    @GetMapping("all")
    public BaseResult<List<Category>> findAll(){
        List<Category> all = categoryService.findAll();
        return BaseResult.ok(all);
    }
}
