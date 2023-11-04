package com.adrian.memberapi.exception;

public class EntityPersistenceException extends RuntimeException{
    public EntityPersistenceException(String message){
        super(message);
    }
}
