package com.cskaoyan.hackernews.bean;


import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 19:45
 * @需求:
 * @思路说明:
 */
public class Comment {

    private Integer id;

    private String content;

    private Date createdDate;

    private User user; //评论人

    private News news; //评论的哪条新闻

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
