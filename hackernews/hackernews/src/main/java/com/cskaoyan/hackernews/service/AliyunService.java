package com.cskaoyan.hackernews.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 16:06
 * @需求:
 * @思路说明:
 */
public interface AliyunService {
    String saveFileToOSS(MultipartFile file) throws IOException;
}
