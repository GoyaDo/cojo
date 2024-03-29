package com.ysmjjsy.goya.cojo.permissions.service;

import com.ysmjjsy.goya.cojo.permissions.domain.Permissions;
import com.ysmjjsy.goya.cojo.role.domain.Role;

import java.util.List;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 23:16
 */
public interface PermissionsService {

    /**
     * 根据角色列表获取权限列表
     * @param roles 角色列表
     * @return 权限列表
     */
    List<Permissions> queryPermissionsByRoles(List<Role> roles);
}
