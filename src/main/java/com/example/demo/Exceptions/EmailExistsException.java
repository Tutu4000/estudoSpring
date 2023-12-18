package com.example.demo.Exceptions;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message){
        super(message);
    }
}
