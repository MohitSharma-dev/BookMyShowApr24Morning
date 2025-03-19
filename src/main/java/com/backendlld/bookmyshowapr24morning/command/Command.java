package com.backendlld.bookmyshowapr24morning.command;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
