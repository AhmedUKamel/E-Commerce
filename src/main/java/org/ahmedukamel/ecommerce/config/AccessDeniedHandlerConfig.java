package org.ahmedukamel.ecommerce.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;


@Configuration
@RequiredArgsConstructor
public class AccessDeniedHandlerConfig implements AccessDeniedHandler {
    private final MessageSourceUtils messageSourceUtils;
    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        String message = messageSourceUtils.getMessage("operation.failed.not.authorized.user");
        ApiResponse apiResponse = new ApiResponse(false, message);
        objectMapper.writeValue(response.getWriter(), apiResponse);
    }
}
