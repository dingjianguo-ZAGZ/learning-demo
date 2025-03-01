package com.su.shopping_admin_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper<Role> {
    //根据id查询角色
    Role findById(Long rid);
    //删除角色所有权限
    void deleteRoleAllPermission(Long rid);
    //删除用户——角色表中的数据
    void deleteAllAdmin(Long rid);
    //给角色添加权限
    void addPermissionToRole(@Param("rid") Long rid,@Param("pid") Long pid);
}
