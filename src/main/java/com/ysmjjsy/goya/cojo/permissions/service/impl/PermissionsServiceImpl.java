package com.ysmjjsy.goya.cojo.permissions.service.impl;

import com.ysmjjsy.goya.cojo.permissions.domain.Permissions;
import com.ysmjjsy.goya.cojo.permissions.repository.PermissionsRepository;
import com.ysmjjsy.goya.cojo.permissions.service.PermissionsService;
import com.ysmjjsy.goya.cojo.role.domain.Role;
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
public class PermissionsServiceImpl implements PermissionsService {

    private final PermissionsRepository permissionsRepository;

    @Override
    public List<Permissions> queryPermissionsByRoles(List<Role> roles) {
        return permissionsRepository.queryPermissionsByRoles(roles);
    }
}
