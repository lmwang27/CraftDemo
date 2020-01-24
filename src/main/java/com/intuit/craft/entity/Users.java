package com.intuit.craft.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME",length = 100)
    private String username;

    @Column(name = "PASSWORD",length = 100)
    private String password;

    @Column(name = "EMAIL",length = 200)
    private String email;

    @Column(name = "PICURL",length = 200)
    private String picUrl;

    @Column(name = "followers")
    private long followers;

    @Column(name = "following")
    private long following;

    @Column(name = "tweets")
    private long tweets;

    @CreationTimestamp
    @Column(name = "created_at",length = 45)
    private Timestamp createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }

    public long getTweets() {
        return tweets;
    }

    public void setTweets(long tweets) {
        this.tweets = tweets;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UsersEntity [id=" + id + ", username=" + username +
                ", password=" + password + ", email=" + email   +  ", picUrl=" + picUrl + "]";
    }
}
