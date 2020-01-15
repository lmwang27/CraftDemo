package com.intuit.craft.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "USERNAME",length = 100)
    private String username;

    @Column(name = "PASSWORD",length = 100)
    private String password;

    @Column(name = "EMAIL",length = 200)
    private String email;

    @Column(name = "PICURL",length = 200)
    private String picUrl;

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

    @Override
    public String toString() {
        return "UsersEntity [id=" + id + ", username=" + username +
                ", password=" + password + ", email=" + email   +  ", picUrl=" + picUrl + "]";
    }
}
