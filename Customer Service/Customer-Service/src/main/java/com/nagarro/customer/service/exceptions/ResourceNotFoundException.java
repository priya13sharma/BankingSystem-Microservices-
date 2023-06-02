package com.nagarro.customer.service.exceptions;


public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found on server!!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String customer, String userId, String userId1) {
    }
}

