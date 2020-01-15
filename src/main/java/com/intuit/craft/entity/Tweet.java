package com.intuit.craft.entity;

import javax.persistence.*;

@Entity
@Table(name = "TWEET")
public class Tweet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "USER_ID",length = 20)
    private long userId;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "PIC_URL",length = 200)
    private String picURL;

    @Column(name = "CREATED_TIME",length = 45)
    private String createdTime;

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
