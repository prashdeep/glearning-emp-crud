package com.glearning.empcrud.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="twitter_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Range(min = 18, max = 60, message = "Age should be greater than 18")
    private int age;

    public User(){}

    public User(String name){
        this.name = name;
    }

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tweet> tweets = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="users_followers",
     joinColumns = @JoinColumn(name = "followers"),
     inverseJoinColumns = @JoinColumn(name = "following"))

    private Set<User> followers = new HashSet<>();


    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> following = new HashSet<>();

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public void addFollower(User follower){
        follower.getFollowing().add(this);
        this.getFollowers().add(follower);
    }


    public long getUserId() {
        return userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addTweet(Tweet tweet){
        this.getTweets().add(tweet);
        tweet.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}