package com.glearning.empcrud.controller;

import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;
import com.glearning.empcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/*
   bean id ="usercontroller" class="">
      <propery name="userService" ref="userService"
 */
@Component
public class UserController {

    @Autowired
    private UserService userService;

    public User saveUser(User user){
        return this.userService.saveUser(user);
    }

    public void addTweet(long userId, Tweet tweet){
        this.userService.addTweet(userId, tweet);
    }

    public Set<Tweet> fetchTweetsByUserId(@PathVariable("id") long userId){
        return this.userService.getAllTweetsByUserId(userId);
    }

    public Set<User> getFollowers(long userId){
        return this.userService.getFollowersByUserId(userId);
    }

    public Set<User> getFollowing(long userId) {
        return this.userService.getFollowingByUserId(userId);
    }
}