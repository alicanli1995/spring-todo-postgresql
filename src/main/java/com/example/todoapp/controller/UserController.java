package com.example.todoapp.controller;


import com.example.todoapp.model.User;
import com.example.todoapp.service.user.UserService;
import com.example.todoapp.controller.request.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

import java.util.Optional;
=======
>>>>>>> 4f3323f26e59ffe7f8a869c55c996292fba5be64

@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")

public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String showRegistrationForm(){
        return "registration";
    }

    @ModelAttribute("user")
    public UserRegisterRequest userRegisterDto(){
        return new UserRegisterRequest();
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegisterRequest userRegisterRequest){
        User user = userRegisterRequest.convertToMember();
        if(userService.contains(user.getMail())){
            return "redirect:/registration?error";
        }
        else{
            userService.saveMember(user);
            return "redirect:/registration?success";
        }
    }

}
