package com.intuit.craft.newsfeed;

import com.intuit.craft.entity.NewsFeed;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.NewsFeedRepo;
import com.intuit.craft.service.FriendshipService;

import java.util.List;

class NewsFeedTweetUpdater implements Runnable {
    Tweet tweet;
    FriendshipService friendshipService;
    NewsFeedRepo newsFeedRepo;

    NewsFeedTweetUpdater(Tweet tweet, FriendshipService friendshipService, NewsFeedRepo newsFeedRepo) {
        this.tweet = tweet;
        this.friendshipService = friendshipService;
        this.newsFeedRepo = newsFeedRepo;
    }
    @Override
    public void run() {
        List<Long> followers = friendshipService.getAllFollower(tweet.getUserId());
        followers.add(tweet.getUserId());
        for (Long follower : followers) {
            NewsFeed newsFeed = new NewsFeed();
            newsFeed.setUserId(follower);
            newsFeed.setTweetId(tweet.getId());
            newsFeedRepo.save(newsFeed);
        }
        newsFeedRepo.flush();
    }
}