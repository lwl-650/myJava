package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.GoUrlService;
import util.result.R;

@RestController
public class GoUrlController {
    @Autowired
    private GoUrlService goUrlService;

    @PostMapping("getGoUrl")
    public R getGoUrl(){
        return R.success(goUrlService.findAllUrl());
    }
}
