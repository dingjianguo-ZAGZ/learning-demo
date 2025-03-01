package com.su.shopping_admin_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.su.shopping_common.pojo.Admin;
import com.su.shopping_common.pojo.Permission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 删除用户所有角色
     * @param aid
     */
    public void deleteAdminAllRole(Long aid);
    /**
     * 查询用户角色和权限
     */
    public Admin findById(Long id);

    /**
     * 给用户添加角色
     */
    public void addRoleToRole(@Param("aid") Long aid,@Param("rid") Long rid);

    public List<Permission> findAllPermission(String username);
}
