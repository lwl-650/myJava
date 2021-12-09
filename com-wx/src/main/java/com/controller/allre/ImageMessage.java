package com.controller.allre;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{
    @XStreamAlias("PicUrl")
    private String picurl;



    public ImageMessage(Map<String,String> requestMap, String picurl) {
        super(requestMap);
      this.setMsgType("image");
        this.picurl = picurl;


    }

 

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }




}
