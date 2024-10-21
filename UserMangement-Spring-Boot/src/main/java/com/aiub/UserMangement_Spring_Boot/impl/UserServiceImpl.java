package com.aiub.UserMangement_Spring_Boot.impl;

import com.aiub.UserMangement_Spring_Boot.entity.User;
import com.aiub.UserMangement_Spring_Boot.repo.UserRepo;
import com.aiub.UserMangement_Spring_Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;

    @Override
    public User createUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        return optionalUser.get();

    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        User previousUser = userRepo.findById(user.getId()).get();

        previousUser.setFirstName(user.getFirstName());
        previousUser.setLastName(user.getLastName());
        previousUser.setEmail(user.getEmail());

        User updateUser = userRepo.save(previousUser);

        return updateUser;
    }

    @Override
    public void deleteUser(Long userId) {
            userRepo.deleteById(userId);
    }
}
