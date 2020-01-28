package com.intuit.craft.service;

import com.intuit.craft.dto.TweetDTO;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.newsfeed.NewsFeedHelper;
import com.intuit.craft.repository.NewsFeedRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

public class TweetServiceUnitTest {

    @InjectMocks
    private TweetService tweetService;

    @Mock
    NewsFeedHelper newsFeedHelper;

    @Mock
    NewsFeedRepo newsFeedRepo;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(tweetService, "newsFeedEnabled", true);
    }

    @Test
    public void testFeed() {
        List<Tweet> tweetList = new ArrayList<>();
        Tweet tweet1 = new Tweet();
        tweet1.setId(121);
        tweet1.setUserId(222);
        tweet1.setContent("first tweet");
        Tweet tweet2 = new Tweet();
        tweet2.setId(321);
        tweet2.setUserId(111);
        tweet2.setContent("second tweet");
        tweetList.add(tweet1);
        tweetList.add(tweet2);

        Mockito.when(newsFeedHelper.feed(123L)).thenReturn(tweetList);

        List<TweetDTO> feeds = tweetService.feed(123L);
        Assert.assertNotNull(feeds);
        Assert.assertEquals(2, feeds.size());
        for (TweetDTO tweetDTO: feeds) {
            if (tweetDTO.getId() != 121 && tweetDTO.getId() != 321) {
                Assert.fail("id is wrong");
            }
            if (tweetDTO.getId() == 121) {
                Assert.assertEquals("first tweet", tweetDTO.getContent());
            } else if (tweetDTO.getId() == 322) {
                Assert.assertEquals("second tweet", tweetDTO.getContent());
            }
        }
    }
}
