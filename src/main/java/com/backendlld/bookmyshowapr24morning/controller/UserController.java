package com.backendlld.bookmyshowapr24morning.controller;

import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.dto.SignUpRequestDTO;
import com.backendlld.bookmyshowapr24morning.dto.SignUpResponseDTO;
import com.backendlld.bookmyshowapr24morning.model.User;
import com.backendlld.bookmyshowapr24morning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public SignUpResponseDTO signUp(SignUpRequestDTO request){
        SignUpResponseDTO response = new SignUpResponseDTO();
        try{
            // call the service
            User user = userService.signUp(
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword()
            );
            response.setUserId(user.getId());
            response.setMessage("User successfully registered!");
            response.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage(ex.getMessage());
        }
        return  response;
    }
}
