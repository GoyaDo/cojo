package com.ysmjjsy.goya.cojo.configuration.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author 77394
 * @description TODO
 * @className CommonLoginFailureHandler
 * @date 2024/3/29 11:58
 */
@Component
@Slf4j
public class CommonLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.warn("认证失败");
        response.setHeader("failed", LocalDateTime.now().toString());
    }
}
