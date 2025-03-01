package com.su.shopping_admin_service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_admin_service.mapper.PermissionMapper;
import com.su.shopping_common.pojo.Permission;
import com.su.shopping_common.service.PermissionService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@DubboService
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public void add(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void update(Permission permission) {
        permissionMapper.updateById(permission);
    }

    @Override
    public void delete(Long id) {
        //删除权限
        permissionMapper.deleteById(id);
        //删除中间表数据
        permissionMapper.deletePermissionAllRole(id);
    }

    @Override
    public Permission findById(Long id) {
        Permission permission = permissionMapper.selectById(id);
        return permission;
    }

    @Override
    public Page<Permission> search(int page, int size) {
        Page<Permission> permissionPage = permissionMapper.selectPage(new Page<>(page, size), null);
        return permissionPage;
    }

    @Override
    public List<Permission> findAll() {
        List<Permission> permissions = permissionMapper.selectList(null);
        return permissions;
    }
}
