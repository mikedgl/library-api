package com.mikedgl.livrariaapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionDTO> resourceNotFoundException(ResourceNotFound e, HttpServletRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(Instant.now());
        exceptionDTO.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionDTO.setError("Resource not found.");
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

}
