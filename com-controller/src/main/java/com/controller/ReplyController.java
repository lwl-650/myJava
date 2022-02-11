package com.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Reply;
import service.ReplyService;
import util.result.R;
import util.timeUtil.GetTimer;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    /**
     *
     * @return
     */
    @PostMapping("findAllReply")
    public R findAll(){
        return R.success(replyService.findAllReply());
    }

    @PostMapping("addReply")
    public R add(@Param("videos_id") int videos_id,
                 @Param("user_id") int user_id,
                 @Param("text") String text,
                 @Param("last_id") int last_id
                 ){
        Reply reply = new Reply();
        reply.setVideos_id(videos_id);
        reply.setUser_id(user_id);
        reply.setText(text);
        reply.setLast_id(last_id);

        GetTimer getTimer=new GetTimer();


        reply.setRtime(getTimer.getTimer());

        replyService.addReply(reply);
        int id=reply.getId();
        System.out.println(id);
        Map<String, Integer> map = new HashMap<String, Integer>();
         map.put("id",id);
        return R.success(map);
    }

    @PostMapping("delReply")
    public R delReply(int id){

        return R.success(replyService.delReply(id));
    }

    @PostMapping("getByVid")
    public R getByVid(Integer vid){

        return R.success(replyService.findReplyByVid(vid));
    }

    @PostMapping("getByVidPages")
    public R getByVidPages(@Param("vid") Integer vid,@Param("pages") int pages){

        if(pages==0){
            pages=1;
        }else{
            if(pages!=1){
                pages=(pages-1)*5;
            }else{
                pages=0;
            }
        }
        int num=5;
        return R.success(replyService.findByIdPage(vid,pages,num));
    }
}
