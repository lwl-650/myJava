package com.controller;


import com.alibaba.fastjson.JSON;
import com.qiniu.util.Json;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import service.UserService;
import util.result.R;
import util.redisUtil.RedisUtil;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public R login(@Param("username") String username, @Param("password") String password){
//        redisUtil.set("石榴","猪");
//        System.out.println(redisUtil.get("石榴"));

        System.out.println("1223");
        return userService.login(username,password)? R.personalizado(0,"登录成功",true):
                R.personalizado(-1,"登录失败",false);
    }

    /**
     *
     * @return
     */
    @PostMapping("get")
    public R get(){

        return R.success(userService.findAll());

    }

    /**
     *
     * @return
     */
    @PostMapping("index")
    public String index(){

        return "index";

    }
}
