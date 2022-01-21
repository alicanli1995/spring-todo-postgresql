package com.example.todoapp.controller;


import com.example.todoapp.model.User;
import com.example.todoapp.service.user.UserService;
import com.example.todoapp.controller.request.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")

public class UserController {

    private final UserService userService;

    @GetMapping
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
        userService.saveMember(user);
        return "redirect:/registration?success";
    }

}
