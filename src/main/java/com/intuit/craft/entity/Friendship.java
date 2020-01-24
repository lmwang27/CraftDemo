package com.intuit.craft.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "FROM_USER_ID",length = 20)
    private long fromUserId;

    @Column(name = "TO_USER_ID",length = 20)
    private long toUserId;

    @CreationTimestamp
    @Column(name = "created_at",length = 45)
    private Timestamp createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }
    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public Timestamp getCreatedAt() { return createdAt; }

    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
