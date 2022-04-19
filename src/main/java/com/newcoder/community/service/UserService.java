package com.newcoder.community.service;

import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2022/4/12 -- 20:47.
 *
 * @author 金伸睿
 * @version 1.0
 */

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //根据用户id查询用户名
    public User selectById(int userId) {
        return userMapper.selectById(userId);
    }

}
