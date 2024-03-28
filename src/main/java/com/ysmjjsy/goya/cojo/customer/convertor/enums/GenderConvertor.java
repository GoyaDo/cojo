package com.ysmjjsy.goya.cojo.customer.convertor.enums;

import com.ysmjjsy.goya.cojo.constant.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/17 20:13
 */
@Converter
public class GenderConvertor implements AttributeConverter<Gender,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer code) {
        return Gender.of(code).orElse(null);
    }

}
