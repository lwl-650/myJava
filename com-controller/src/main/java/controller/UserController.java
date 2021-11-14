package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("get")
    public List<User> get(){

        return userService.findAll();

    }
    @PostMapping("set")
    public String set(){

        return "SET";

    }
    @PostMapping("index")
    public String index(){

        return "index";

    }
}
