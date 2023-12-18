package com.example.demo.Exceptions;

public class IdDoesNotExist extends RuntimeException{
    public IdDoesNotExist(String message){
        super(message);
    }
}