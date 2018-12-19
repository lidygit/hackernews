package com.cskaoyan.hackernews.service.impl;

import com.cskaoyan.hackernews.bean.News;
import com.cskaoyan.hackernews.mapper.NewsMapper;
import com.cskaoyan.hackernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 15:51
 * @需求:
 * @思路说明:
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findNews() {
        return newsMapper.findNews();
    }

    @Override
    public boolean addNews(News news) {
        int insert=newsMapper.insert(news);
        if (insert==1){
            return  true;
        }

        return false;
    }

    @Override
    public News findNewsById(Integer id) {
        return newsMapper.findNewsById(id);
    }


}
