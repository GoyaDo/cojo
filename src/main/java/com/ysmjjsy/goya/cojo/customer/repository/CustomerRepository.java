package com.ysmjjsy.goya.cojo.customer.repository;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaRepository;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:21
 */
@Repository
public interface CustomerRepository extends BaseJpaRepository<Customer,Long> {
}
