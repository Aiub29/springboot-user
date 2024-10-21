package com.aiub.UserMangement_Spring_Boot.controllers;

import com.aiub.UserMangement_Spring_Boot.entity.User;
import com.aiub.UserMangement_Spring_Boot.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserControllers {

    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      User saveUser=  userService.createUser(user);

      return  new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user= userService.getUserById(userId);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
     List<User> users=   userService.getAllUser();
     return  new ResponseEntity<>(users,HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);

       User updateUser= userService.updateUser(user);

       return  new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long userId){
        userService.deleteUser(userId);
        return  new ResponseEntity<>("User Delete Successfull",HttpStatus.OK);
    }

}
