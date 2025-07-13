package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.dto.UserRegisterRequest;
import com.shihchi.springbootmall.model.User;

public interface UserDao {

    public Integer createUser(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);
}
