package com.example.travel.service;
import com.example.travel.mapper.UserMapper;
import com.example.travel.model.User;
import com.example.travel.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0) {
            // Insert User
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
        else {
            // Update token
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setBio(user.getBio());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());

            UserExample example = new UserExample();
            example.createCriteria()
                    .andAccountIdEqualTo(user.getAccountId());
            userMapper.updateByExampleSelective(updateUser, example);
        }

    }
}
