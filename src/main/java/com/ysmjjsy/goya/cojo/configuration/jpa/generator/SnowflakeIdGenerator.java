package com.ysmjjsy.goya.cojo.configuration.jpa.generator;

import com.ysmjjsy.goya.cojo.configuration.identifier.SnowflakeIdUtil;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serial;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/18 20:43
 */
public class SnowflakeIdGenerator implements IdentifierGenerator {


    @Serial
    private static final long serialVersionUID = 2388344493166528273L;

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return SnowflakeIdUtil.nextId();
    }
}
