package com.su.shopping_admin_service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_admin_service.mapper.AdminMapper;
import com.su.shopping_common.pojo.Admin;
import com.su.shopping_common.pojo.Permission;
import com.su.shopping_common.service.AdminService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@DubboService
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public void add(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void update(Admin admin) {
        //判断前端传来的是否为空密码
        String password = admin.getPassword();
        if(!StringUtils.hasText(password)){//为空密码
            //密码仍然为原来的密码
            //查询原来的密码
            password = adminMapper.selectById(admin.getAid()).getPassword();
            //为修改的管理员设置密码
            admin.setPassword(password);

        }
        adminMapper.updateById(admin);
    }

    @Override
    public void delete(Long id) {
        //删除用户的所有角色
        adminMapper.deleteAdminAllRole(id);
        //删除用户
        adminMapper.deleteById(id);
    }

    @Override
    public Admin findById(Long id) {
        return adminMapper.findById(id);
    }

    @Override
    public void updateRoleToAdmin(Long aid, Long[] rids) {
        //先删除之前的角色
        adminMapper.deleteAdminAllRole(aid);
        //为管理员添加角色
        for (Long rid : rids) {
            adminMapper.addRoleToRole(aid,rid);
        }

    }

    @Override
    public Page<Admin> search(int page, int size) {
        return adminMapper.selectPage(new Page(page,size),null);
    }

    @Override
    public Admin findByAdminName(String username) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Admin admin = adminMapper.selectOne(wrapper);
        return admin;
    }

    @Override
    public List<Permission> findAllPermission(String username) {
        List<Permission> allPermission = adminMapper.findAllPermission(username);
        return allPermission;
    }


}
