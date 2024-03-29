package com.ysmjjsy.goya.cojo.sercurity;

import com.google.common.collect.Lists;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import com.ysmjjsy.goya.cojo.customer.repository.CustomerRepository;
import com.ysmjjsy.goya.cojo.permissions.domain.Permissions;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author 77394
 * @description TODO
 * @className CustomerUserService
 * @date 2024/3/29 9:16
 */
@Service
@RequiredArgsConstructor
public class CustomerUserService implements UserDetailsManager {

    private final CustomerRepository customerRepository;

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public LoginCustomer loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = this.customerRepository.findByUsername(username).orElse(null);
        if (customer == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        Set<Role> roles = customer.getRoles();

        List<Permissions> permissions = roles.stream().map(Role::getPermissions).flatMap(Set::stream).toList();

        List<String> authorities = Lists.newArrayList();
        List<String> roleCodes = roles.stream().map(r -> "ROLE_" + r.getRoleCode()).toList();
        List<String> permissionsCodes = permissions.stream().map(Permissions::getPermissionsCode).toList();

        authorities.addAll(roleCodes);
        authorities.addAll(permissionsCodes);

        return new LoginCustomer(customer,roles,authorities);
    }
}
