package com.controller.allre;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XStreamAlias("xml")
public class NewsMessage extends BaseMessage{

    @XStreamAlias("ArticleCount")
    private String articlecount;
    @XStreamAlias("Articles")
    private List<Article> articles=new ArrayList<Article>();



    public void setArticlecount(String articlecount) {
        this.articlecount = articlecount;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getArticlecount() {
        return articlecount;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public NewsMessage(Map<String, String> requestMap, String articlecount, List<Article> articles) {
        super(requestMap);
        setMsgType("news");
        this.articlecount=articlecount;
        this.articles= articles;
    }

}
