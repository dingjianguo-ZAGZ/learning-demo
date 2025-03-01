package com.su.shopping_admin_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Permission;

public interface PermissionMapper extends BaseMapper<Permission> {
    //删除角色——权限中间表数据
    void deletePermissionAllRole(Long id);
}
