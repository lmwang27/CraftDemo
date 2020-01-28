package com.intuit.craft.dto;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

public class FriendshipDTOUnitTest {

    @Test
    public void TestGetAndSet() {
        long id = 12345;
        long fromUserId = 2132;
        long toUserId = 4654;
        Timestamp createdAt = new Timestamp(1577836800);

        FriendshipDTO friendshipDTO = new FriendshipDTO();
        friendshipDTO.setId(id);
        friendshipDTO.setFrom_user_id(fromUserId);
        friendshipDTO.setTo_user_id(toUserId);
        friendshipDTO.setCreated_at(createdAt);

        Assert.assertEquals(id, friendshipDTO.getId());
        Assert.assertEquals(fromUserId, friendshipDTO.getFrom_user_id());
        Assert.assertEquals(toUserId, friendshipDTO.getTo_user_id());
        Assert.assertEquals(createdAt, friendshipDTO.getCreated_at());
    }

}
