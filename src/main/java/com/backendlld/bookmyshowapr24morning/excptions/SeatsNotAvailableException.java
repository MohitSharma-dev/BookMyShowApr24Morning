package com.backendlld.bookmyshowapr24morning.excptions;

public class SeatsNotAvailableException extends Exception{

    public SeatsNotAvailableException(String message){
        super(message);
    }
}
