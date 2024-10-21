package com.aiub.UserMangement_Spring_Boot.service;

import com.aiub.UserMangement_Spring_Boot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
}
