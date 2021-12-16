package com.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import pojo.Ssq;
import service.SsqService;
import util.result.R;

@RestController
public class OtherController {


    @Autowired
    private SsqService ssqService;

    /**
     * 双色球
     *
     * @return
     */

    @Scheduled(cron = "0 15 2 * * ?")
    public void scheduledSsq() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", "b919609752eac679e509cd49f10cfed0");  //
        String responseEntity = restTemplate.
                getForObject("http://apis.juhe.cn/lottery/query?key=b919609752eac679e509cd49f10cfed0&lottery_id=ssq", String.class,
                        params);
        System.out.println(responseEntity);
//        JSONObject obj= JSON.parseObject(responseEntity);

        JsonParser jp = new JsonParser();
        JsonObject jo = jp.parse(responseEntity).getAsJsonObject();
        String ssqId = jo.get("result").getAsJsonObject().get("lottery_no").getAsString();
        if (ssqService.getRe(Integer.parseInt(ssqId + 9)) == null) {
            Ssq ssq = new Ssq();
            ssq.setSsqId(Integer.parseInt(ssqId));
            ssq.setSsqtext(responseEntity);
            ssqService.setSsq(ssq);
        } else {
            return;
        }
    }


    /**
     *
     * @return
     */
    @PostMapping("/ssq")
    public R ssq() {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", "b919609752eac679e509cd49f10cfed0");  //
        String responseEntity = restTemplate.
                getForObject("http://apis.juhe.cn/lottery/query?key=b919609752eac679e509cd49f10cfed0&lottery_id=ssq", String.class,
                        params);
//        System.out.println(responseEntity);
//        JSONObject obj= JSON.parseObject(responseEntity);

        JsonParser jp = new JsonParser();
        JsonObject jo = jp.parse(responseEntity).getAsJsonObject();
        String ssqId = jo.get("result").getAsJsonObject().get("lottery_no").getAsString();

        if (ssqService.getRe(Integer.parseInt(ssqId)) == null) {
            Ssq ssq = new Ssq();
            ssq.setSsqId(Integer.parseInt(ssqId));
            ssq.setSsqtext(responseEntity);
            return R.success(ssqService.setSsq(ssq));
        } else {
            return R.error();
        }


    }

    /**
     * @return
     */
    @PostMapping("getSsq")
    public R getSsq() {

        return R.success(ssqService.getOneSsq());
    }
}
