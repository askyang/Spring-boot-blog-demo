package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.User;
import cn.ufan0.blog_test.mapper.UserMapper;
import cn.ufan0.blog_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void UpdateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUser() {
        return userMapper.getUser();
    }
}
