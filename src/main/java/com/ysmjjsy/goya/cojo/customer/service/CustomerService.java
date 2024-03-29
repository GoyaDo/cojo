package com.ysmjjsy.goya.cojo.customer.service;

import com.ysmjjsy.goya.cojo.cmd.RegisterCustomerRequest;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:31
 */
public interface CustomerService {

    /**
     * 注册用户
     * @param request 注册信息
     * @return 响应
     */
    RegisterCustomerRequest registerCustomer(RegisterCustomerRequest request);

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    Customer findCustomerByUsername(String username);

}
