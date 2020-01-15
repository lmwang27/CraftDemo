package com.intuit.craft.service;

import com.intuit.craft.dto.TweetDTO;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.repository.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Post a tweet /News Feed /Timeline
 **/
@Service
@Transactional
public class TweetService {

    @Autowired
    TweetRepo tweetRepo;

    @Autowired
    FriendshipService friendshipService;

    public List<TweetDTO> feed(Long userId) {
        List<Long> follows = friendshipService.getAllFollows(userId);
        follows.add(userId);
        List<Tweet> tweetList = tweetRepo.findTop100ByUserIdInOrderByIdDesc(follows);

        return toTweetDTOList(tweetList);
    }

    public void tweet(TweetDTO tweetDTO) {
        if (tweetDTO == null) {
            return;
        }
        Tweet tweet = toTweet(tweetDTO);
        tweetRepo.saveAndFlush(tweet);
    }

    private Tweet toTweet(TweetDTO tweetDTO) {
        Tweet tweet = new Tweet();
        if (tweetDTO == null) {
            return tweet;
        }
        tweet.setUserId(tweetDTO.getUser_id());
        tweet.setContent(tweetDTO.getContent());
        tweet.setPicURL(tweetDTO.getPicURL());
        tweet.setCreatedTime(tweetDTO.getCreatedTime());
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
            tweetDTO.setPicURL(tweet.getPicURL());
            tweetDTO.setCreatedTime(tweet.getCreatedTime());
            tweetDTOList.add(tweetDTO);
        }
        return tweetDTOList;
    }
}
