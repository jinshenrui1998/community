package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2022/4/1 -- 15:31.
 *
 * @author 金伸睿
 * @version 1.0
 */

@Mapper
public interface DiscussPostMapper {

    //根据用户id查帖子 如果userID为 -1等特殊值就表示查所有的帖子
    //实现的是分页查询
    //offset表示查询结果的起始行号，limit表示每页查询多少个
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId,@Param("offset") int offset, @Param("limit") int limit);

    //查询帖子的总数
    //如果方法只有一个参数，并且在<if>里使用，就必须加别名
    //就是动态查询中可能无参数
    int selectDiscussPostRows(@Param("userId") int userId);


}
