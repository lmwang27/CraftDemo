package com.intuit.craft.entity;

import javax.persistence.*;

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
}
