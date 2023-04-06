package com.mikedgl.livrariaapi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ExceptionDTO {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
