package com.one.study.error;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Hidden
@Slf4j
public class GlobalExceptionHandler {



    //400:사용자 입력 잘못 , 404:데이터X
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Map<String,String>> handleAllUncaughtException(CommonException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("code", e.getErrorCode().getCode());
        errorResponse.put("message", e.getErrorCode().getMessage());

        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(errorResponse);
    }


    // 최상위 Exception 클래스를 처리하여 500 Internal Server Error 반환
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleRuntimeException(Exception e) {
        log.error("Unexpected error occurred: {}", e.getMessage(), e);

        Map<String, String> errorResponse = new HashMap<>();
        // Enum에 정의한 INTERNAL_SERVER_ERROR 사용
        errorResponse.put("code", ErrorCode.INTERNAL_SERVER_ERROR.getCode());
        errorResponse.put("message", ErrorCode.INTERNAL_SERVER_ERROR.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

}
