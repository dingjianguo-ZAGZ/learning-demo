package com.su.shopping_admin_service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_admin_service.mapper.RoleMapper;
import com.su.shopping_common.pojo.Role;
import com.su.shopping_common.service.RoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@DubboService
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public void delete(Long id) {
        //删除角色
        roleMapper.deleteById(id);
        //删除角色权限
        roleMapper.deleteRoleAllPermission(id);
        //删除中间表数据
        roleMapper.deleteAllAdmin(id);
    }

    @Override
    public Role findById(Long rid) {
        Role role = roleMapper.findById(rid);
        return role;
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.selectList(null);
    }

    @Override
    public Page<Role> search(int page, int size) {
        Page<Role> pages = roleMapper.selectPage(new Page<>(page, size), null);
        return pages;
    }

    @Override
    public void updatePermissionToRole(Long rid, Long[] pids) {
        //删除权限
        roleMapper.deleteRoleAllPermission(rid);
        //添加权限
        for (Long pid : pids) {
            roleMapper.addPermissionToRole(rid,pid);
        }

    }
}
