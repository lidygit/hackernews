package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.Comment;
import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.bean.vo.CommentVO;
import com.cskaoyan.hackernews.service.AliyunService;
import com.cskaoyan.hackernews.service.CommentService;
import com.cskaoyan.hackernews.service.NewsService;
import com.cskaoyan.hackernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 15:47
 * @需求:
 * @思路说明:
 */
@Controller
public class NewsController {


    @Autowired
    private NewsService newsService;

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private CommentService commentService;

    /**文件上传与回显*/
    @ResponseBody
    @RequestMapping("/uploadImage/")
    public Map<String,Object> uploadImage(MultipartFile file){

        HashMap<String, Object> map = new HashMap<>();

        String url= null;
        try {
            url = aliyunService.saveFileToOSS(file);
            map.put("msg",url);
            map.put("code",0);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("msg","fail");
            map.put("code",1);
        }

        return map;

    }


    /**分享*/
    @ResponseBody
    @RequestMapping("/user/addNews")
    public Map<String,Object> addNews(News news, HttpSession session){

        HashMap<String, Object> map = new HashMap<>();

        if (news.getTitle()==null||
            news.getLink()==null||
            news.getImage()==null)
        {
            map.put("msg","填写信息不能为空");
        }

        User user = (User) session.getAttribute("user");
        news.setUser(user);
        news.setLikeCount(0);
        news.setCommentCount(0);

        boolean add=newsService.addNews(news);

        if (!add){
            map.put("msg","fail");
        }

        return map;
    }


    /**显示新闻详情*/
    @RequestMapping("/news/{id}")
    public String newsDetail(@PathVariable("id") Integer id,
                             Model model){

        News news=newsService.findNewsById(id);
        List<Comment> commentList=commentService.findCommentByNid(id);

        ArrayList<CommentVO> commentVOS = new ArrayList<>();

        for (Comment comment:commentList) {
            CommentVO commentVO = new CommentVO();
            commentVO.setComment(comment);
            commentVO.setUser(comment.getUser());//此news的评论人

            commentVOS.add(commentVO);
        }

        model.addAttribute("comments",commentVOS);

        model.addAttribute("news",news);
        model.addAttribute("owner",news.getUser());//owner是news发布人
        model.addAttribute("like",news.getLikeCount());

        return "detail";

    }


}
