package com.ysmjjsy.goya.cojo.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author 77394
 * @description TODO
 * @className LockStatus
 * @date 2024/3/29 9:58
 */
@Getter
@AllArgsConstructor
public enum LockStatus implements BaseEnum{

    UNLOCK(0, "未锁定"),
    LOCK(1, "已锁定")
    ;

    private final Integer code;

    private final String name;

    public static Optional<LockStatus> of(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(BaseEnum.parseByCode(LockStatus.class, code));
    }


}
