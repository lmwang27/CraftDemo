package com.intuit.craft.dto;

import java.sql.Timestamp;

public class FriendshipDTO {

    private long id;
    private long from_user_id;
    private long to_user_id;
    private Timestamp created_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(long from_user_id) {
        this.from_user_id = from_user_id;
    }

    public long getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(long to_user_id) {
        this.to_user_id = to_user_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
