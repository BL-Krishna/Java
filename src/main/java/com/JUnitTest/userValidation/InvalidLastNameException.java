package com.JUnitTest.userValidation;

public class InvalidLastNameException extends RuntimeException{
    public InvalidLastNameException(String message){
        super(message);
    }
}
