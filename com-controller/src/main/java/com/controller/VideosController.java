package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VideosService;
import util.result.R;

@RestController
public class VideosController {

    @Autowired
    private VideosService videosService;

    @PostMapping("findVideosById")
    public R findById(int vid){

        return R.success(videosService.findById(vid));
    }

    @PostMapping("allVid")
    public R findAll(){
        return R.success(videosService.findViall());
    }

    @PostMapping("findByVid")
    public R findByVid(Integer vid){
        return R.success(videosService.findByVid(vid));
    }
}
