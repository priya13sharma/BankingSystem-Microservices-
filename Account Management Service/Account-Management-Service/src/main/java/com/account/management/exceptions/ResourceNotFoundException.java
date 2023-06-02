package com.account.management.exceptions;


public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found on server!!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String account, String userId, String userId1) {
    }
}

