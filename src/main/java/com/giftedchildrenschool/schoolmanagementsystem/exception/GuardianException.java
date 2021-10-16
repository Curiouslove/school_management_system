package com.giftedchildrenschool.schoolmanagementsystem.exception;

public class GuardianException extends RuntimeException{

    public GuardianException(){

    }

    public GuardianException(String message){
        super(message);
    }

    public GuardianException(String message, Throwable ex){
        super(message, ex);
    }

    public GuardianException(Throwable ex){
        super(ex);
    }
}
