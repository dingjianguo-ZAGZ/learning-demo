package com.su.shopping_category_service.sercice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_category_service.mapper.CategoryMapper;
import com.su.shopping_common.pojo.Category;
import com.su.shopping_common.service.CategoryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.List;
@DubboService
public class CategoryServiceImpl implements CategoryService  {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
        refreshRedisCategory();
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
        refreshRedisCategory();
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        Category category = categoryMapper.selectById(id);
        category.setStatus(status);
        categoryMapper.updateById(category);
        refreshRedisCategory();
    }

    @Override
    public void delete(Long[] ids) {
        categoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public Page<Category> search(int page, int size) {
        return categoryMapper.selectPage(new Page<>(page,size),null);
    }

    @Override
    public List<Category> findAll() {
        //先从redis中查询
        // 1.1获取操作redis中操作list数据的对象
        ListOperations<String,Category> listOperations = redisTemplate.opsForList();
        // 1.2从集合中获取所有启用的广告
        List<Category> categoryList  = listOperations.range("categories", 0, -1);
        if(categoryList != null && categoryList.size() > 0 ){
            //查询到直接返回
            System.out.println("从redis中查询");
            return categoryList;
        }else {
            //没有查到，从数据库查询所有启用广告，并添加到redis中
            System.out.println("从数据库中查询");
            //2.1设置查询条件
            QueryWrapper<Category> wrapper = new QueryWrapper<>();
            wrapper.eq("status",1);
            //2.2 从数据库中查询
            List<Category> categories = categoryMapper.selectList(wrapper);
            //2.3放入redis中
            listOperations.leftPushAll("categories",categories);
            return categories;
        }
    }

    /**
     * 更新redis中的广告数据
     */
    public void refreshRedisCategory(){
        //从数据库中查询广告
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("status",1);
        List<Category> categories = categoryMapper.selectList(wrapper);
        //删除redis中旧的广告数据
        redisTemplate.delete("categories");
        //给redis添加新的广告
        ListOperations<String,Category> listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("categories",categories);
    }
}
