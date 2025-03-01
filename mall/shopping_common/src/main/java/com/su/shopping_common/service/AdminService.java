package com.su.shopping_common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Admin;
import com.su.shopping_common.pojo.Permission;

import java.util.List;

public interface AdminService {
    //新增管理员
    void add(Admin admin);
    //修改管理员
    void update(Admin admin);
    //删除管理员
    void delete(Long id);
    //根据id查询管理员
    Admin findById(Long id);
    //修改管理员角色
    void updateRoleToAdmin(Long aid,Long[] rid);
    //分页查询管理员
    Page<Admin> search(int page, int size);
    //根据用户名查询管理员
    Admin findByAdminName(String username);
    //根据用户名查询管理员的所有权限
    List<Permission> findAllPermission(String username);
}
