package com.backendlld.bookmyshowapr24morning.excptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
