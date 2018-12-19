package com.cskaoyan.hackernews.mapper;

import com.cskaoyan.hackernews.bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/19 19:41
 * @需求:
 * @思路说明:
 */

@Mapper
public interface CommentMapper {



    @Select({
            "select comment.id,comment.content,comment.createdDate,",
            "user.id,user.name,user.password,user.headUrl",
            "from comment",
            "left join user on user.id=comment.uid",
            "where comment.nid=#{id}"
    })
    @ResultMap("com.cskaoyan.hackernews.mapper.CommentMapper.BaseResultMap")
    List<Comment> findCommentByNid(Integer id);


    @Insert({
            "insert into comment (id,content,createdDate,uid,nid)",
            "values(null,#{comment.content},now(),#{comment.user.id},#{comment.news.id})"
    })
    int addComment(@Param("comment") Comment comment);
}
