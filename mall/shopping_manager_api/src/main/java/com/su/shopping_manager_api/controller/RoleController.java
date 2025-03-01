package com.su.shopping_manager_api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Role;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.RoleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台角色
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @DubboReference
    private RoleService roleService;

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody Role role) {
        roleService.addRole(role);
        return BaseResult.ok();
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody Role role) {
        roleService.updateRole(role);
        return BaseResult.ok();
    }

    /**
     * 删除角色
     *
     * @param rid
     * @return
     */
    @DeleteMapping("/delete")
    public BaseResult delete(Long rid) {
        roleService.delete(rid);
        return BaseResult.ok();
    }

    /**
     * 根据id查询角色
     *
     * @param rid
     * @return
     */
    @GetMapping("/findById")
    public BaseResult<Role> findById(Long rid) {
        Role role = roleService.findById(rid);
        return BaseResult.ok(role);
    }

    /**
     * 分页查询角色
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('/role/search')")
    public BaseResult<Page<Role>> search(int page, int size) {
        Page<Role> pages = roleService.search(page, size);
        return BaseResult.ok(pages);
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @GetMapping("/findAll")
    public BaseResult<List<Role>> findAll() {
        List<Role> all = roleService.findAll();
        return BaseResult.ok(all);
    }

    /**
     * 修改角色权限
     *
     * @param rid
     * @param pids
     * @return
     */
    @PutMapping("/updatePermissionToRole")
    public BaseResult updatePermissionToRole(Long rid, Long[] pids) {
        roleService.updatePermissionToRole(rid, pids);
        return BaseResult.ok();
    }
}
