package com.shihchi.springbootmall.service.impl;

import com.shihchi.springbootmall.dao.UserDao;
import com.shihchi.springbootmall.dto.UserRegisterRequest;
import com.shihchi.springbootmall.model.User;
import com.shihchi.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest){
        try {
            return userDao.createUser(userRegisterRequest);
        } catch (Exception e) {
            logger.error("Register error - email = {} - {}", userRegisterRequest.getEmail(), e.getMessage());
            throw e;
        }

    };

    @Override
    public User getUserById(Integer userId){
        return userDao.getUserById(userId);
    };
}
