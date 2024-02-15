package org.ahmedukamel.ecommerce.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint {
    private final MessageSourceUtils messageSourceUtils;
    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String message = messageSourceUtils.getMessage("operation.failed.not.authorized.request");
        ApiResponse apiResponse = new ApiResponse(false, message);
        objectMapper.writeValue(response.getWriter(), apiResponse);
    }
}
