package com.JUnitTest.userValidation;

public class InvalidMobileNumberException extends RuntimeException{
    public InvalidMobileNumberException(String message){
        super(message);
    }
}
