package com.glearning.empcrud.client;

import com.glearning.empcrud.controller.UserController;
import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class TwitterCLI {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        UserController userController = applicationContext.getBean(UserController.class);

        User user = new User("rahul");
        user.setDateOfBirth(LocalDate.of(2000, 10,10));

        Tweet tweet = new Tweet();
        tweet.setMessage("Hello world message");
        tweet.setCreatedDate(LocalDate.now());

        Tweet tweet2 = new Tweet();
        tweet2.setMessage("My second tweet to the universe !!");
        tweet2.setCreatedDate(LocalDate.now());

        user.addTweet(tweet);
        user.addTweet(tweet2);

        userController.saveUser(user);



    }
}