package com.intuit.craft.dto;

public class UsersDTO {
    private String username;
    private String password;
    private String email;
    private String picUrl;

    public UsersDTO(){

    }

    public UsersDTO(String username, String password, String email, String picUrl){
        this.username = username;
        this.password = password;
        this.email = email;
        this.picUrl = picUrl;

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
