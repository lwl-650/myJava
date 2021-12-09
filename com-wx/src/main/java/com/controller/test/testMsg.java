package com.controller.test;

import com.controller.allre.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class testMsg {
    @Test
    public  void testmsg(){
        Map<String,String> map=new HashMap<String, String>();
        map.put("ToUserName","to");
        map.put("FromUserName","from");
        map.put("MsgType","type");
        TextMessage tm=new TextMessage(map,"lalal");
        XStream stream =new XStream();
        stream.processAnnotations(TextMessage.class);
        String xml=stream.toXML(tm);
        System.out.println(xml);

    }
}
