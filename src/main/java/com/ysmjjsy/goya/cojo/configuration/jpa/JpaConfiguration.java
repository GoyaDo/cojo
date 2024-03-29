package com.ysmjjsy.goya.cojo.configuration.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ysmjjsy.goya.cojo.configuration.jpa.auditor.SpringSecurityAuditorAware;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:20
 */
@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
