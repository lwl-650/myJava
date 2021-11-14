package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import result.R;
import service.UserService;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("get")
    public R get(){

        return R.success(userService.findAll());

    }
    
    @PostMapping("index")
    public String index(){

        return "index";

    }
}
