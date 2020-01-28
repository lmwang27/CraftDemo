package com.intuit.craft.dto;

import java.sql.Timestamp;

public class UsersDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private String picUrl;
    private long followers;
    private long following;
    private long tweets;
    private Timestamp created_at;
    public UsersDTO(){

    }

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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    /*
     CREATE TABLE user(
        id bigint(20) NOT NULL AUTO_INCREMENT,
        user_name varchar(100) NOT NULL UNIQUE,
        user_password varchar(20) NOT NULL,
        email varchar(100) NOT NULL,
        PRIMARY KEY (id)
     )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
}
