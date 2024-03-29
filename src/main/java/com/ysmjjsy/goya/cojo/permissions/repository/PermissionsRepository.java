package com.ysmjjsy.goya.cojo.permissions.repository;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaRepository;
import com.ysmjjsy.goya.cojo.permissions.domain.Permissions;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:21
 */
@Repository
public interface PermissionsRepository extends BaseJpaRepository<Permissions,Long> {

    List<Permissions> queryPermissionsByRoles(List<Role> roles);

}
