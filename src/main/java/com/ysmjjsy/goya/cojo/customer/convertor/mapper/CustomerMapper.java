package com.ysmjjsy.goya.cojo.customer.convertor.mapper;

import com.ysmjjsy.goya.cojo.cmd.RegisterCustomerRequest;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/17 20:21
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(source = "password", target = "password")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "birthday", target = "birthday")
    Customer convert(RegisterCustomerRequest request);

    @Mapping(source = "password", target = "password")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "birthday", target = "birthday")
    RegisterCustomerRequest convert(Customer customer);


}
