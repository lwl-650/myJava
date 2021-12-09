package com.controller;

import com.controller.allre.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxService {

    public static Map<String, String> parseRequest(InputStream is) throws DocumentException {
        Map<String,String> map=new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        Document document=reader.read(is);
        Element root =document.getRootElement();
        List<Element> elements=root.elements();
        for (Element e:elements){
            map.put(e.getName(),e.getStringValue());
        }
          return map;
    }

    /**
     * 用于处理所有的事件和消息回复
     */
    public static  String getRespose(Map<String,String> requestMap){
        BaseMessage msg=null;
        String msgType =requestMap.get("MsgType");
        if ("text".equals(msgType)) {
            if(requestMap.get("Content").equals("1")){
                msg=dealImageMessage(requestMap);
            }else if(requestMap.get("Content").equals("2")){
                msg = dealNewsMessage(requestMap);

            }else{
                msg = dealTextMessage(requestMap);
            }

        } else if ("image".equals(msgType)) {

        } else if ("voice".equals(msgType)) {
        }else if ("video".equals(msgType)) {
        }else if ("shortvideo".equals(msgType)) {
        }else if ("location".equals(msgType)) {
        }else if ("link".equals(msgType)) {
        }
        return beanToXml(msg);
    }

    /**
     *
     * @param msg
     * @return
     */
    private static String beanToXml(BaseMessage msg){
        XStream stream =new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(NewsMessage.class);
        String xml=stream.toXML(msg);
        return xml;
    }
    /**
     * 文本消息
     * @param requestMap
     * @return
     */
    private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
        TextMessage msg=new TextMessage(requestMap,"你要干啥");

//        List<Article> articles=new ArrayList<Article>();
//        articles.add(new Article("这是图文","1","https://i0.hdslb.com/bfs/archive/f7099702f9903c279197ae3948ced7e1b64eefc0.png","https://www.bilibili.com/video/BV1nb411P76t?p=9"));
//        NewsMessage msg =new NewsMessage(requestMap,"1",articles);
//        System.out.println(msg);
        return msg;
    }

    /**
     *
     * @param requestMap
     * @return
     */
    private static BaseMessage dealImageMessage(Map<String, String> requestMap){
        ImageMessage imageMessage=new ImageMessage(requestMap,"https://i0.hdslb.com/bfs/archive/f7099702f9903c279197ae3948ced7e1b64eefc0.png");
        return imageMessage;
    }
    private static BaseMessage dealNewsMessage(Map<String, String> requestMap){
        List<Article> articles=new ArrayList<Article>();
        articles.add(new Article("这是图文","1","https://i0.hdslb.com/bfs/archive/f7099702f9903c279197ae3948ced7e1b64eefc0.png","https://www.bilibili.com/video/BV1nb411P76t?p=9"));
        NewsMessage newsMessage =new NewsMessage(requestMap,"1",articles);
//        System.out.println(newsMessage);
        return newsMessage;
    }
}
