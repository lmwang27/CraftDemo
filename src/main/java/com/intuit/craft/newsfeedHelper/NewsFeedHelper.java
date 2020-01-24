package com.intuit.craft.newsfeedHelper;

import com.intuit.craft.entity.Friendship;
import com.intuit.craft.entity.NewsFeed;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.NewsFeedRepo;
import com.intuit.craft.service.FriendshipService;
import com.intuit.craft.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsFeedHelper {
    @Autowired
    NewsFeedRepo newsFeedRepo;

    @Autowired
    FriendshipService friendshipService;

    @Autowired
    TweetService tweetService;

    public List<Tweet> feed(Long userId) {
        List<NewsFeed> newsFeeds = newsFeedRepo.findTop100ByUserIdOrderByCreatedAtDesc(userId);
        List<Long> tweetIds = new ArrayList<>();
        for (NewsFeed newsFeed : newsFeeds) {
            tweetIds.add(newsFeed.getTweetId());
        }

        return tweetService.getTweets(tweetIds);
    }

    public void tweet(Tweet tweet) {
        new Thread(new NewsFeedTweetUpdater(tweet, friendshipService, newsFeedRepo)).start();
    }


    public void follow(Friendship friendship) {
        new Thread(new NewsFeedFollowUpdater(friendship, tweetService, newsFeedRepo)).start();
    }

    public void unFollow(Friendship friendship) {
        new Thread(new NewsFeedUnFollowUpdater(friendship, tweetService, newsFeedRepo)).start();
    }
}

