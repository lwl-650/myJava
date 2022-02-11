package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pojo.User;
import service.UserService;
import util.JwtUtil.JwtUtil;
import util.result.R;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QqController {

    @Autowired
    private UserService userService;

    String client_id="101990958";
    String client_secret="37e96358312d327ef646afe83e7337eb";


    @PostMapping("qqlogin")
    public R qqLogin(String code,String redirect_uri){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", "101990958");
        params.put("client_secret", "37e96358312d327ef646afe83e7337eb");
        params.put("code", code);
        params.put("redirect_uri", redirect_uri);
        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_secret={client_secret}&client_id={client_id}&code={code}&redirect_uri={redirect_uri}";
        String str = restTemplate.getForObject (url, String.class,params);

        String str1 = str.substring(0, str.indexOf("&"));
        String getaccess_token = str.substring(0, str1.indexOf("="));
        String access_token=str1.substring(getaccess_token.length()+1,str1.length());


        int index = str.indexOf("&");
        int  index2 = str.indexOf("&", index + 1);
        String str2 = str.substring(index2 + 1);
        String getrefresh_token = str.substring(0, str2.indexOf("="));
        String refresh_token=str2.substring(getrefresh_token.length()+1,str2.length());


        //截取_之后字符串
        String str3 = str.substring(0, str.indexOf("_in="));
        String str4 = str.substring(str3.length()+4, str.length());
        String expires_in=str4.substring(0,str4.indexOf("&"));
        System.out.println(access_token);
        System.out.println(refresh_token);
        System.out.println(expires_in);//access_token过期时间

//        C383B83129E01164289E1BD7579E336A
//        5A5AFA83129BE1E5A5D290C957623A7A
//        7776000
//        ADD2B3D28B83FABD2EC9286C4F8D9FB8
        String meurl="https://graph.qq.com/oauth2.0/me?fmt=json&access_token="+access_token;

        String me = restTemplate.getForObject (meurl, String.class);


        JSONObject jsonObject = JSON.parseObject(me);

        System.out.println("openid:"+jsonObject.get("openid"));


        String infourl="https://graph.qq.com/user/get_user_info?access_token="+access_token+
                "&oauth_consumer_key="+client_id+"&openid="+jsonObject.get("openid");

        String info = restTemplate.getForObject (infourl, String.class);

        JSONObject user= JSON.parseObject(info);
        System.out.println(user);
        System.out.println(user.get("nickname"));

        User setuser=new User();
        setuser.setAvatar(user.getString("figureurl_2"));
        setuser.setName(user.getString("nickname"));
        setuser.setCity(user.getString("city"));
        setuser.setGender(user.getString("gender"));
        setuser.setOpenid(jsonObject.getString("openid"));
        setuser.setPassword("123456");
        JwtUtil jwtUtil=new JwtUtil();
        Map<String,Object> res=new HashMap<String,Object>();
        if (userService.findThis(jsonObject.getString("openid"))==null) {


            if(userService.addUser(setuser)){
                User getUser=userService.loginByOpenid(jsonObject.getString("openid"));
                res.put("data",getUser);
                res.put("token",jwtUtil.createToken(getUser));
                return R.success(res);
            }else{

                return R.personalizado(-1,"登陆失败","");
            }
        }else{
            User getUser=userService.loginByOpenid(jsonObject.getString("openid"));
            res.put("data",getUser);
            res.put("token",jwtUtil.createToken(getUser));
            return R.success(res);
        }


    }


    public static void main(String[] args) {
        String str=  "access_token=C383B83129E01164289E1BD7579E336A&expires_in=7776000&refresh_token=5A5AFA83129BE1E5A5D290C957623A7A";

        String str1 = str.substring(0, str.indexOf("&"));
        String getaccess_token = str.substring(0, str1.indexOf("="));
        String access_token=str1.substring(getaccess_token.length()+1,str1.length());


        int index = str.indexOf("&");
        int  index2 = str.indexOf("&", index + 1);
        String str2 = str.substring(index2 + 1);
        String getrefresh_token = str.substring(0, str2.indexOf("="));
        String refresh_token=str2.substring(getrefresh_token.length()+1,str2.length());


        //截取_之后字符串
        String str3 = str.substring(0, str.indexOf("_in="));
        String str4 = str.substring(str3.length()+4, str.length());
        String expires_in=str4.substring(0,str4.indexOf("&"));

//ADD2B3D28B83FABD2EC9286C4F8D9FB8  openid唯一

        System.out.println(access_token);
        System.out.println(refresh_token);
        System.out.println(expires_in);
    }

}
