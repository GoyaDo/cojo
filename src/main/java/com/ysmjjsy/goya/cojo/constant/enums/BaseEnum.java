package com.ysmjjsy.goya.cojo.constant.enums;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/13 21:33
 */
public interface BaseEnum {

    /**
     * 获取code码存入数据库
     *
     * @return 获取编码
     */
    Integer getCode();

    /**
     * 获取编码名称，便于维护
     *
     * @return 获取编码名称
     */
    String getName();

    /**
     * 根据code码获取枚举
     *
     * @param cls enum class
     * @param code enum code
     * @return get enum
     */
    static <T extends BaseEnum> T parseByCode(Class<T> cls, Integer code) {
        for (T t : cls.getEnumConstants()) {
            if (t.getCode().intValue() == code.intValue()) {
                return t;
            }
        }
        return null;
    }
}
