package com.ysmjjsy.goya.cojo.customer.service.impl;

import com.ysmjjsy.goya.cojo.cmd.RegisterCustomerRequest;
import com.ysmjjsy.goya.cojo.configuration.identifier.SnowflakeIdUtil;
import com.ysmjjsy.goya.cojo.constant.enums.LockStatus;
import com.ysmjjsy.goya.cojo.customer.convertor.mapper.CustomerMapper;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import com.ysmjjsy.goya.cojo.customer.repository.CustomerRepository;
import com.ysmjjsy.goya.cojo.customer.service.CustomerService;
import com.ysmjjsy.goya.cojo.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:32
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterCustomerRequest registerCustomer(RegisterCustomerRequest request) {
        Customer customer = customerMapper.convert(request);
        customer.setOpenId(SnowflakeIdUtil.nextIdStr());
        customer.setUsername(request.phone());
        customer.setRoles(roleService.defaultRoles());
        customer.setLockStatus(LockStatus.UNLOCK);
        customer.setPassword(passwordEncoder.encode(request.password()));
        return customerMapper.convert(customerRepository.save(customer));
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findByUsername(username).orElse(null);
    }
}
