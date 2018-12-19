package com.cskaoyan.hackernews.bean.vo;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 16:40
 * @需求:
 * @思路说明:
 */
public class VO {

    private News news;

    private User user;

    private Integer like=1;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
