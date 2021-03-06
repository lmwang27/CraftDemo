package com.intuit.craft.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @CreationTimestamp
    @Column(name = "created_at",length = 45)
    private Timestamp createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
