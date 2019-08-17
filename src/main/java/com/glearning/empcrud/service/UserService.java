package com.glearning.empcrud.service;

import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;

import java.util.Set;

public interface UserService {

    User saveUser(User user);

    Set<Tweet> getAllTweetsByUserId(long userId);

    void addTweet(long userId, Tweet tweet);

    Set<User> getFollowersByUserId(long userId);

    Set<User> getFollowingByUserId(long userId);
}