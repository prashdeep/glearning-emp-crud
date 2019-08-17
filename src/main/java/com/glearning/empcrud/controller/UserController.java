package com.glearning.empcrud.controller;

import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;
import com.glearning.empcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/*
   bean id ="usercontroller" class="">
      <propery name="userService" ref="userService"
 */
@Component(value="usercontroller")
public class UserController {

    @Autowired
    private UserService userService;

    public User saveUser(User user){
        return this.userService.saveUser(user);
    }

    public void addTweet(long userId, Tweet tweet){
        this.userService.addTweet(userId, tweet);
    }

    public Set<Tweet> fetchTweetsByUserId(long userId){
        return this.userService.getAllTweetsByUserId(userId);
    }
}