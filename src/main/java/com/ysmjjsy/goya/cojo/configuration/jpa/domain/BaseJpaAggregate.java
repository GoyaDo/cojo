package com.ysmjjsy.goya.cojo.configuration.jpa.domain;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.domain.AbstractAggregateRoot;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/13 19:47
 */
@MappedSuperclass
public class BaseJpaAggregate<T, A extends AbstractAggregateRoot<A>> extends AbstractAggregateRoot<A> {

}
