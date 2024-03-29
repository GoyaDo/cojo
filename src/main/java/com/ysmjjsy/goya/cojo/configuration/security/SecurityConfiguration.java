package com.ysmjjsy.goya.cojo.configuration.security;

import com.ysmjjsy.goya.cojo.configuration.security.handler.CommonLoginFailureHandler;
import com.ysmjjsy.goya.cojo.configuration.security.handler.CommonLoginSuccessHandler;
import com.ysmjjsy.goya.cojo.sercurity.CustomerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:21
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CommonLoginFailureHandler commonLoginFailureHandler;
    private final CommonLoginSuccessHandler commonLoginSuccessHandler;
    private final CustomerUserService customerUserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorize ->
                                authorize.requestMatchers("/auth/**").permitAll()
                                        .requestMatchers("/v3/api-docs").permitAll()
                                        .anyRequest().authenticated()
                ).formLogin(f -> {
                    f
                            .successHandler(commonLoginSuccessHandler)
                            .failureHandler(commonLoginFailureHandler);
                });

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
