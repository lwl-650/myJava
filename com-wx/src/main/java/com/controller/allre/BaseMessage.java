package com.controller.allre;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class BaseMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public BaseMessage(Map<String,String> requestMap){
        this.toUserName=requestMap.get("FromUserName");
        this.fromUserName=requestMap.get("ToUserName");
        this.createTime=System.currentTimeMillis()/1000+"";
    }
}
