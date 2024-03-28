package com.ysmjjsy.goya.cojo.cmd;

import com.ysmjjsy.goya.cojo.constant.enums.Gender;

import java.time.LocalDate;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:29
 */
public record RegisterCustomerRequest(
        String phone,
        String password,
        String nickName,
        Gender gender,
        LocalDate birthday
) {
}
