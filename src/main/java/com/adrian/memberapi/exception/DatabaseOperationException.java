package com.adrian.memberapi.exception;

public class DatabaseOperationException extends RuntimeException{
    public DatabaseOperationException(String message){
        super(message);
    }
}
