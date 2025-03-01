package com.su.shopping_manager_api.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Category;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.CategoryService;
import istio.v1.auth.Ca;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.Temporal;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @DubboReference
    private CategoryService categoryService;

    /**
     * 新增广告
     * @param category
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody Category category){
        categoryService.add(category);
        return BaseResult.ok();
    }

    /**
     * 修改广告
     * @param category
     * @return
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody Category category){
        categoryService.update(category);
        return BaseResult.ok();
    }

    /**
     * 修改广告状态
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/updateStatus")
    public BaseResult updateStatus(Long id,Integer status){
        categoryService.updateStatus(id,status);
        return BaseResult.ok();
    }

    /**
     * 删除广告
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public BaseResult delete(Long[] ids){
        categoryService.delete(ids);
        return BaseResult.ok();
    }

    /**
     * 根据id查询广告
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public BaseResult<Category> findById(Long id){
        Category category = categoryService.findById(id);
        return BaseResult.ok(category);
    }

    /**
     * 分页查询广告
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search")
    public BaseResult<Page<Category>> search(int page,int size){
        Page<Category> categoryPage = categoryService.search(page, size);
        return BaseResult.ok(categoryPage);
    }
}
