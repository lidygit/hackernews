package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.mapper.CommentMapper;
import com.cskaoyan.hackernews.mapper.NewsMapper;
import com.cskaoyan.hackernews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 19:42
 * @需求:
 * @思路说明:
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private NewsMapper newsMapper;


    @Transactional
    @Override
    public List<Comment> findCommentByNid(Integer newsId) {
        return commentMapper.findCommentByNid(newsId);
    }

    @Transactional
    @Override
    public boolean addComment(Comment comment) {

        int add=commentMapper.addComment(comment);
        int update=newsMapper.updateCommentCount(comment.getNews().getId());

        if (add==1&&update==1){
            return true;
        }

        return false;
    }
}
