package com.ysmjjsy.goya.cojo.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:46
 */
@Getter
@AllArgsConstructor
public enum Gender implements BaseEnum{

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");


    private final Integer code;

    private final String name;

    public static Optional<Gender> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(Gender.class, code));
    }
}
