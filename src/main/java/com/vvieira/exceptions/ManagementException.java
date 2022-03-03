package com.vvieira.exceptions;

public class ManagementException extends RuntimeException{
    public ManagementException(String error){
        super(error);
    }
}
