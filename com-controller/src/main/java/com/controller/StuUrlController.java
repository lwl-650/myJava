package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import service.StuUrlService;
import util.result.R;

@RestController
public class StuUrlController {
    @Autowired
    private StuUrlService stuUrlService;
//
    @PostMapping("getStu")
    public R getStu(){
        return R.success(stuUrlService.findSall());
    }
}
