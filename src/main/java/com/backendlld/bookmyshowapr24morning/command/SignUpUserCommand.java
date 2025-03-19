package com.backendlld.bookmyshowapr24morning.command;

import com.backendlld.bookmyshowapr24morning.controller.UserController;
import com.backendlld.bookmyshowapr24morning.dto.SignUpRequestDTO;
import com.backendlld.bookmyshowapr24morning.dto.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpUserCommand implements Command {
    @Autowired
    private UserController userController;
    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        if(words[0].equals("SignUpUser") && words.length == 4) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        String userName = words[1];
        String email = words[2];
        String password = words[3];

        SignUpRequestDTO request = new SignUpRequestDTO();
        request.setEmail(email);
        request.setPassword(password);
        request.setUsername(userName);

        SignUpResponseDTO responseDTO = userController.signUp(request);
        System.out.println(responseDTO.getMessage());
    }
}
