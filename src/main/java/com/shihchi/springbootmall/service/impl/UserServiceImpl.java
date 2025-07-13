package com.shihchi.springbootmall.service.impl;

import com.shihchi.springbootmall.dao.UserDao;
import com.shihchi.springbootmall.dto.UserRegisterRequest;
import com.shihchi.springbootmall.model.User;
import com.shihchi.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest){
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null) {
            logger.warn("Register error - the email {} is registered", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDao.createUser(userRegisterRequest);
    };

    @Override
    public User getUserById(Integer userId){
        return userDao.getUserById(userId);
    };
}
