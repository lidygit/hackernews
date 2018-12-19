package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.bean.vo.VO;
import com.cskaoyan.hackernews.service.NewsService;
import com.cskaoyan.hackernews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 15:50
 * @需求:
 * @思路说明:
 */

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @RequestMapping("/hackernews")
    public String home(Model model, HttpServletRequest request){

        List<News> newsList = newsService.findNews();

        Collections.reverse(newsList);//逆序

        List<VO> vos = new ArrayList<>();

        for (News news:newsList) {
            VO vo = new VO();
            vo.setNews(news);
            vo.setUser(news.getUser());
            vos.add(vo);
        }

        System.out.println(vos);

        model.addAttribute("vos",vos);

        return "home";
    }



}
