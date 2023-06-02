package com.account.management.exceptions;

public class AccountNotFoundException  extends RuntimeException{
    public AccountNotFoundException(){
        super("Resource not found on server!!");
    }
    public AccountNotFoundException(String message){
        super(message);
    }

}
