package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.Comment;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 19:41
 * @需求:
 * @思路说明:
 */
public interface CommentService {
    List<Comment> findCommentByNid(Integer id);

    boolean addComment(Comment comment);
}
