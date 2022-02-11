package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Answer;
import service.AnswerService;
import util.result.R;
import util.timeUtil.GetTimer;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;


    @PostMapping("findAllAns")
    public R findAllAns(int rid){
        return R.success(answerService.findAll(rid));
    }

    @PostMapping("addAns")
    public R addAns(String text,int toid,int fid,int rid){

        Answer answer=new Answer();
        answer.setText(text);
        answer.setFid(fid);
        answer.setRid(rid);
        answer.setToid(toid);
        GetTimer getTimer=new GetTimer();
        answer.setAn_time(getTimer.getTimer());

        return R.success(answerService.addAns(answer));
    }
}
