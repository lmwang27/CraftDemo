package com.intuit.craft.newsfeed;


import com.intuit.craft.entity.Friendship;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.NewsFeedRepo;
import com.intuit.craft.service.TweetService;

import java.util.List;

class NewsFeedUnFollowUpdater implements Runnable {
    Friendship friendship;
    TweetService tweetService;
    NewsFeedRepo newsFeedRepo;

    NewsFeedUnFollowUpdater(Friendship friendship, TweetService tweetService, NewsFeedRepo newsFeedRepo) {
        this.friendship = friendship;
        this.tweetService = tweetService;
        this.newsFeedRepo = newsFeedRepo;
    }
    @Override
    public void run() {
        List<Tweet> tweets = tweetService.getTweets(friendship.getToUserId());
        for (Tweet tweet : tweets) {
            newsFeedRepo.deleteByUserIdAndTweetId(friendship.getFromUserId(), tweet.getId());
            newsFeedRepo.flush();
        }
    }
}
