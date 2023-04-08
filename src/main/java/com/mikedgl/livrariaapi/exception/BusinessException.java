package com.mikedgl.livrariaapi.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String msg){
        super(msg);
    }
}
