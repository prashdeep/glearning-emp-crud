package com.glearning.empcrud.client;

import com.glearning.empcrud.config.AppConfig;
import com.glearning.empcrud.controller.UserController;
import com.glearning.empcrud.model.Tweet;
import com.glearning.empcrud.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Set;

public class TwitterCLI {

    public static void main(String[] args) {
       // ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserController userController = applicationContext.getBean(UserController.class);

        User rahul = new User("rahul");
        rahul.setDateOfBirth(LocalDate.of(2000, 10,10));

        Tweet tweet = new Tweet();
        tweet.setMessage("Hello world message");
        tweet.setCreatedDate(LocalDate.now());

        Tweet tweet2 = new Tweet();
        tweet2.setMessage("My second tweet to the universe !!");
        tweet2.setCreatedDate(LocalDate.now());

        rahul.addTweet(tweet);
        rahul.addTweet(tweet2);

        User mohan = new User("mohan");
        User vikaram = new User("vikram");




        rahul.addFollower(mohan);
        rahul.addFollower(vikaram);

        userController.saveUser(rahul);

        //Set<User> following = userController.getFollowing(mohan.getUserId());

        //following.forEach((user -> System.out.println(user.getName())));
        userController.fetchTweetsByUserId(rahul.getUserId()).forEach(tweet1 -> System.out.println(tweet1.getMessage()));



    }
}