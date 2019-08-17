package com.glearning.empcrud.service;

import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;
import com.glearning.empcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Set<Tweet> getAllTweetsByUserId(long userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user.getTweets();
        }
        return null;
    }

    public void updateUser(User user){
        this.userRepository.save(user);
    }


    @Override
    public void addTweet(long userId, Tweet tweet) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.addTweet(tweet);
        }
    }

    @Override
    public Set<User> getFollowersByUserId(long userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFollowers();
        }
        return null;
    }

    @Override
    public Set<User> getFollowingByUserId(long userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFollowing();
        }
        return null;
    }

    @Override
    public Set<Tweet> getTweetsByFollowerId(long follwerId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}