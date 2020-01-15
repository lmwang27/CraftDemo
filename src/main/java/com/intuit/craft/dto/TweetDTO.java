package com.intuit.craft.dto;

public class TweetDTO {
    private long id;
    private long user_id;
    private String content;
    private String picURL;
    private String createdTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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


    /*
        CREATE TABLE tweet(
        id bigint(20) NOT NULL AUTO_INCREMENT,
        user_id bigint(20) NOT NULL,
        content text,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id)
        REFERENCE user(id),
        PRIMARY KEY (id)
     )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
}
