package com.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

@RestController
public class Wx {
    private String TOKEN = "lwl";

    @RequestMapping("wx")
    public @ResponseBody String wx(@RequestParam(name="signature",required=false) String signature,
                                   @RequestParam(name="timestamp",required=false) String timestamp,
                                   @RequestParam(name="nonce",required=false) String nonce,
                                   @RequestParam(name="echostr",required=false) String echostr
){
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String myString = sha1(sortString);
        //校验
        if (myString != null && myString != "" && myString.equals(signature)) {
            System.out.println("签名校验通过");
            //如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
            return echostr;
        } else {
            System.out.println("签名校验失败");
            return "";
        }

    }

    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "wx",method=RequestMethod.POST)
    public void dopost(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        try {
            Map<String,String> requestMap=WxService.parseRequest(request.getInputStream());
//            System.out.println(requestMap);

            String respXml=WxService.getRespose(requestMap);
//            String respXml="<xml><ToUserName>" +
//                    "<![CDATA["+requestMap.get("FromUserName")+"]]>" +
//                    "</ToUserName><FromUserName>" +
//                    "<![CDATA["+requestMap.get("ToUserName")+"]]>" +
//                    "</FromUserName><CreateTime>12345678</CreateTime>" +
//                    "<MsgType><![CDATA[text]]></MsgType>" +
//                    "<Content><![CDATA[https://www.bilibili.com/video/BV1nb411P76t?p=6]]>" +
//                    "</Content> </xml>";

            PrintWriter out =response.getWriter();
            System.out.println(respXml);
            out.print(respXml);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
