package com.ysmjjsy.goya.cojo.customer.convertor.enums;

import com.ysmjjsy.goya.cojo.constant.enums.LockStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author 77394
 * @description TODO
 * @className LockStatusConvertor
 * @date 2024/3/29 10:00
 */
@Converter
public class LockStatusConvertor implements AttributeConverter<LockStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(LockStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public LockStatus convertToEntityAttribute(Integer dbData) {
        return LockStatus.of(dbData).orElse(null);
    }
}
