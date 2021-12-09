package com.th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Index {

    @RequestMapping("/")
    public  String index(Model model){
        model.addAttribute("list","这是list");
        return"index";
    }
}
