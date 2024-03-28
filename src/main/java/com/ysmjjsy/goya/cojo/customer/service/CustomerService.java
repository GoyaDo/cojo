package com.ysmjjsy.goya.cojo.customer.service;

import com.ysmjjsy.goya.cojo.cmd.RegisterCustomerRequest;

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
}
