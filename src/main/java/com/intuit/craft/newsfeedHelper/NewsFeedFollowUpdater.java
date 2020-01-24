package com.intuit.craft.newsfeedHelper;

import com.intuit.craft.entity.Friendship;
import com.intuit.craft.entity.NewsFeed;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.NewsFeedRepo;
import com.intuit.craft.service.TweetService;

import java.util.List;

class NewsFeedFollowUpdater implements Runnable {
    Friendship friendship;
    TweetService tweetService;
    NewsFeedRepo newsFeedRepo;

    NewsFeedFollowUpdater(Friendship friendship, TweetService tweetService, NewsFeedRepo newsFeedRepo) {
        this.friendship = friendship;
        this.tweetService = tweetService;
        this.newsFeedRepo = newsFeedRepo;
    }
    @Override
    public void run() {
        List<Tweet> tweets = tweetService.getTweets(friendship.getToUserId());
        for (Tweet tweet : tweets) {
            NewsFeed newsFeed = new NewsFeed();
            newsFeed.setUserId(friendship.getFromUserId());
            newsFeed.setTweetId(tweet.getId());
            newsFeedRepo.save(newsFeed);
        }
        newsFeedRepo.flush();
    }
}
