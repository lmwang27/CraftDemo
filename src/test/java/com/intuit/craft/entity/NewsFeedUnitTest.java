package com.intuit.craft.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

public class NewsFeedUnitTest {

    @Test
    public void testGetAndSet() {

        long id = 1232;
        long userId = 12;
        long tweetId = 432;
        Timestamp createdAt = new Timestamp(1577836802);

        NewsFeed newsFeed = new NewsFeed();
        newsFeed.setId(id);
        newsFeed.setTweetId(tweetId);
        newsFeed.setUserId(userId);
        newsFeed.setCreatedAt(createdAt);

        Assert.assertEquals(id, newsFeed.getId());
        Assert.assertEquals(userId, newsFeed.getUserId());
        Assert.assertEquals(tweetId, newsFeed.getTweetId());
        Assert.assertEquals(createdAt, newsFeed.getCreatedAt());
    }
}
