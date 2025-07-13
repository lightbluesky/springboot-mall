package com.shihchi.springbootmall.service;

import com.shihchi.springbootmall.dto.UserRegisterRequest;
import com.shihchi.springbootmall.model.User;

public interface UserService {

    public Integer register(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);
}
