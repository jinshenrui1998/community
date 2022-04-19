package com.newcoder.community;

import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created on 2022/4/1 -- 16:53.
 *
 * @author 金伸睿
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("newcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user=new User();
        user.setUsername ("test") ;
        user.setPassword("123456") ;
        user.setSalt ("abc") ;
        user.setEmail ("test@qq.com") ;
        user.setHeaderUrl ("http://WWW.nowcoder.com/101.png") ;
        user.setCreateTime (new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateStatus() {
        userMapper.updateStatus(101, 1);
        User user = userMapper.selectById(101);
        System.out.println(user);
    }


    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
        System.out.println("count" + discussPostMapper.selectDiscussPostRows(0));
    }
}
