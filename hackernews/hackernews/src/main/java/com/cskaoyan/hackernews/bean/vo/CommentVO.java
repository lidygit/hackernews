package com.cskaoyan.hackernews.bean.vo;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.bean.User;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 20:09
 * @需求:
 * @思路说明:
 */
public class CommentVO {

    private Comment comment;

    private User user;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
