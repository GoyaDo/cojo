package com.ysmjjsy.goya.cojo.role.repository;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaRepository;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:21
 */
@Repository
public interface RoleRepository extends BaseJpaRepository<Role,Long> {

    Set<Role> findRoleByRoleCode(String roleCode);
}
