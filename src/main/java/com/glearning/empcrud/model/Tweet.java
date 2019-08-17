package com.glearning.empcrud.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tweets")
public class Tweet {

    @Id
    @GeneratedValue
    private long tweetId;

    private String message;

    private LocalDate createdDate;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return tweetId == tweet.tweetId &&
                Objects.equals(message, tweet.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tweetId, message);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", message='" + message + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}