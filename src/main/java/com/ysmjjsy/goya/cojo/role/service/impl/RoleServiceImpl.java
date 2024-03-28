package com.ysmjjsy.goya.cojo.role.service.impl;

import com.ysmjjsy.goya.cojo.role.domain.Role;
import com.ysmjjsy.goya.cojo.role.repository.RoleRepository;
import com.ysmjjsy.goya.cojo.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 23:16
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> defaultRoles() {
        return roleRepository.findRoleByRoleCode("CUSTOMER");
    }
}
