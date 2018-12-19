package com.cskaoyan.hackernews.service;

import com.cskaoyan.hackernews.bean.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 15:51
 * @需求:
 * @思路说明:
 */
public interface NewsService {

    List<News> findNews();

    boolean addNews(News news);

    News findNewsById(Integer id);
}
