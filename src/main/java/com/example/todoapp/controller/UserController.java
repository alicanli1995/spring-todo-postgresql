package com.example.todoapp.controller;


import com.example.todoapp.model.User;
import com.example.todoapp.service.user.UserService;
import com.example.todoapp.controller.request.UserRegisterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/registration")
@Api(value="Member Controller API Documents")

public class UserController {

    @ApiModelProperty(value = "We are enjecting User Services.")
    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "The method redirect for registration.")
    public String showRegistrationForm(){
        return "registration";
    }

    @ModelAttribute("user")
    @ApiOperation(value = "The method modelling for user registration.")
    public UserRegisterRequest userRegisterDto(){
        return new UserRegisterRequest();
    }

    @PostMapping
    @ApiOperation(value = "The method for create member. This method check mail used or not.")
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
