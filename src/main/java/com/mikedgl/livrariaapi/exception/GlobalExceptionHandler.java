package com.mikedgl.livrariaapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDTO> businessException(BusinessException e, HttpServletRequest request){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(Instant.now());
        exceptionDTO.setStatus(HttpStatus.CONFLICT.value());
        exceptionDTO.setError("Bussines error.");
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){

        List<String> errors =  e.getFieldErrors().stream().map(error -> error.getField()).toList();
        StringBuilder sb = new StringBuilder();
        sb.append("The following fields cannot be null or empty: ");
        errors.forEach(field -> {
            if(errors.indexOf(field) == errors.size() - 1){
                sb.append(field).append(".");
            }
            else sb.append(field).append(", ");
        });

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(Instant.now());
        exceptionDTO.setStatus(HttpStatus.CONFLICT.value());
        exceptionDTO.setError("Invalid argument.");
        exceptionDTO.setMessage(sb.toString());
        exceptionDTO.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }

}
