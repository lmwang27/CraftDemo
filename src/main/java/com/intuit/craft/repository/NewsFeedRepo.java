package com.intuit.craft.repository;

import com.intuit.craft.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NewsFeedRepo extends JpaRepository<NewsFeed, Long> {
    List<NewsFeed> findTop100ByUserIdOrderByCreatedAtDesc(Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from NewsFeed n where n.userId = ?1 and n.tweetId = ?2")
    void deleteByUserIdAndTweetId(Long userId, Long tweetId);
}
