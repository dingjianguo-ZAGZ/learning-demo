package com.su.shopping_manager_api.controller;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Permission;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.PermissionService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台权限
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    @DubboReference
    private PermissionService permissionService;
    @PostMapping("/add")
    public BaseResult add(@RequestBody Permission permission){
        permissionService.add(permission);
        return BaseResult.ok();
    }
    @PutMapping("/update")
    public BaseResult update(@RequestBody Permission permission){
        permissionService.update(permission);
        return BaseResult.ok();
    }
    @DeleteMapping("/delete")
    public BaseResult delete(Long pid){
        permissionService.delete(pid);
        return BaseResult.ok();
    }
    @GetMapping("/findById")
    public BaseResult<Permission> findById(Long pid){
        Permission permission = permissionService.findById(pid);
        return BaseResult.ok(permission);
    }
    @GetMapping("/search")
    public BaseResult<Page<Permission>> search(int page,int size){
        Page<Permission> pages = permissionService.search(page, size);
        return BaseResult.ok(pages);
    }
    @GetMapping("/findAll")
    public BaseResult<List<Permission>> findAll(){
        List<Permission> all = permissionService.findAll();
        return BaseResult.ok(all);
    }
}
