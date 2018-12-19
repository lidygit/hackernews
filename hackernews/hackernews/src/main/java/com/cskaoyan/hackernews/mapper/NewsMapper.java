package com.cskaoyan.hackernews.mapper;


import com.cskaoyan.hackernews.bean.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {
 /*   @Delete({
        "delete from news",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);



    int insertSelective(News record);


    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    @Update({
        "update news",
        "set title = #{title,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "likeCount = #{likecount,jdbcType=INTEGER},",
          "commentCount = #{commentcount,jdbcType=INTEGER},",
          "createdDate = #{createddate,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(News record);*/


    @Select({
            "select",
            "news.id, title, link, image, likeCount, commentCount, createdDate,",
            "user.id as user_id,user.name,user.headUrl",
            "from news",
            "left join user on user.id=news.uid"
    })
    @ResultMap("com.cskaoyan.hackernews.mapper.NewsMapper.BaseResultMap")
    List<News> findNews();

    @Insert({
            "insert into news (id, title, ",
            "link, image, likeCount, ",
            "commentCount, createdDate,uid)",
            "values (null, #{news.title,jdbcType=VARCHAR}, ",
            "#{news.link,jdbcType=VARCHAR}, #{news.image,jdbcType=VARCHAR}, #{news.likeCount,jdbcType=INTEGER}, ",
            "#{news.commentCount,jdbcType=INTEGER}, now(),#{news.user.id})"
    })
    int insert(@Param("news") News record);


    @Select({
            "select",
            "news.id, title, link, image, likeCount, commentCount, createdDate,",
            "user.id as user_id,user.name,user.headUrl",
            "from news",
            "left join user on user.id=news.uid",
            "where news.id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.cskaoyan.hackernews.mapper.NewsMapper.BaseResultMap")
    News findNewsById(Integer id);


    @Update({
            "update news set commentCount=commentCount+1",
            "where id=#{id}"
    })
    int updateCommentCount(Integer id);
}