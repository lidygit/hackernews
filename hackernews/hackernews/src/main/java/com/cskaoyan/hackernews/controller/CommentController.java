package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 20:45
 * @需求:
 * @思路说明:
 */

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;


    //@ResponseBody
    @RequestMapping("/addComment")
    public String addComment(Integer newsId,
                             Comment comment,
                             String commit,
                             HttpSession session){

        HashMap<String, Object> map = new HashMap<>();

        if (!commit.equals("提 交")){
            map.put("msg","fail");
        }

        News news = new News();
        news.setId(newsId);
        comment.setNews(news);

        User user = (User) session.getAttribute("user");
        comment.setUser(user);

        boolean add=commentService.addComment(comment);

        return "redirect:/news/"+newsId;
    }

}
