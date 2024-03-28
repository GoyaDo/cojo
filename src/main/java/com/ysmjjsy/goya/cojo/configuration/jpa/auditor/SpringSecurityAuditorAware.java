package com.ysmjjsy.goya.cojo.configuration.jpa.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/13 19:53
 */
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getPrincipal)
//                .map(Long.class::cast);
        return Optional.of(1L);
    }
}
