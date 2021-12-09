package com.controller.allre;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Article {
    @XStreamAlias("Title")
    private  String title;
    @XStreamAlias("Description")
    private  String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getUrl() {
        return url;
    }

    public Article(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }
}
