package org.ahmedukamel.ecommerce.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;
import java.util.List;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
    private MessageSourceUtils messageSourceUtils;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = messageSourceUtils.getMessage("exception.MethodArgumentNotValid.message");
        List<String> data = exception.getFieldErrors().stream()
                .map(e -> "Error at " + e.getField() + " : " + e.getDefaultMessage()).toList();
        ApiResponse response = new ApiResponse(false, message, data);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        String message = messageSourceUtils.getMessage("exception.EntityNotFound.message",
                exception.getTheClassName(), exception.getIdentifier());
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse> handleMaxUploadSizeExceededException() {
        String message = messageSourceUtils.getMessage("exception.MaxUploadSizeExceeded.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<ApiResponse> handleIOException() {
        String message = messageSourceUtils.getMessage("exception.IO.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = InsufficientAmountException.class)
    public ResponseEntity<ApiResponse> handleInsufficientAmountException(InsufficientAmountException exception) {
        String message = messageSourceUtils.getMessage("exception.InsufficientAmount.message",
                exception.getTheClassName());
        ApiResponse response = new ApiResponse(false, message, exception.getData());
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = DuplicateEntryException.class)
    public ResponseEntity<ApiResponse> handleDuplicateEntryException(DuplicateEntryException exception) {
        String message = messageSourceUtils.getMessage("exception.DuplicateEntry.message",
                exception.getTheClassName(), exception.getIdentifier());
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException() {
        String message = messageSourceUtils.getMessage("exception.HttpMessageNotReadable.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> handleHttpRequestMethodNotSupportedException() {
        String message = messageSourceUtils.getMessage("exception.HttpRequestMethodNotSupported.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(CustomException exception) {
        ApiResponse response = new ApiResponse(false, exception.getMessage());
        return ResponseUtils.badRequestResponse(response);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity<ApiResponse> handleExpiredJwtException() {
        String message = messageSourceUtils.getMessage("exception.ExpiredJwt.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.forbiddenResponse(response);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<ApiResponse> handleBadCredentialsException() {
        String message = messageSourceUtils.getMessage("exception.BadCredentials.message");
        ApiResponse response = new ApiResponse(false, message);
        return ResponseUtils.forbiddenResponse(response);
    }
}
