package com.intuit.craft.service;

import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.entity.Users;
import com.intuit.craft.newsfeedHelper.NewsFeedHelper;
import com.intuit.craft.dto.TweetDTO;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.TweetRepo;
import com.intuit.craft.repository.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Post a tweet /News Feed /Timeline
 **/
@Service
@Transactional
public class TweetService {
    private final Logger log = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    TweetRepo tweetRepo;

    @Autowired
    FriendshipService friendshipService;

    @Autowired
    NewsFeedHelper newsFeedHelper;

    @Autowired
    UsersRepo usersRepo;

    @Value("${craft.enable.newsfeed}")
    boolean newsFeedEnabled;

    public List<TweetDTO> feed(Long userId) {
        log.debug("Getting all the newsFeeds for user:{}",userId);

        if (newsFeedEnabled) {
            return toTweetDTOList(newsFeedHelper.feed(userId));
        }

        List<Long> follows = friendshipService.getAllFollows(userId);
        follows.add(userId);
        List<Tweet> tweetList = tweetRepo.findTop100ByUserIdInOrderByIdDesc(follows);

        return toTweetDTOList(tweetList);
    }

    public void tweet(TweetDTO tweetDTO) {
        if (tweetDTO == null) {
            return;
        }

        log.debug("Posting a new tweet:{}",tweetDTO.getContent());
        Tweet tweet = toTweet(tweetDTO);
        tweet = tweetRepo.saveAndFlush(tweet);
        Users user = usersRepo.findAllById(tweet.getUserId());
        if(user != null){
            user.setTweets(user.getTweets()+1);
            usersRepo.saveAndFlush(user);
        }

        if (newsFeedEnabled) {
            newsFeedHelper.tweet(tweet);
        }
    }

    public List<Tweet> getTweets(List<Long> tweetIds) {
        return tweetRepo.findAllByIdIn(tweetIds);
    }

    public List<Tweet> getTweets(Long userId) {
        return tweetRepo.findAllByUserId(userId);
    }

    private Tweet toTweet(TweetDTO tweetDTO) {
        Tweet tweet = new Tweet();
        if (tweetDTO == null) {
            return tweet;
        }
        tweet.setUserId(tweetDTO.getUser_id());
        tweet.setContent(tweetDTO.getContent());
        return tweet;
    }

    private List<TweetDTO> toTweetDTOList(List<Tweet> tweetList) {
        List<TweetDTO> tweetDTOList = new ArrayList<>();
        if (tweetList == null || tweetList.isEmpty()) {
            return tweetDTOList;
        }
        for (Tweet tweet: tweetList) {
            TweetDTO tweetDTO = new TweetDTO();
            tweetDTO.setId(tweet.getId());
            tweetDTO.setUser_id(tweet.getUserId());
            tweetDTO.setContent(tweet.getContent());
            tweetDTO.setCreatedTime(tweet.getCreatedAt());
            tweetDTOList.add(tweetDTO);
        }
        return tweetDTOList;
    }
}
