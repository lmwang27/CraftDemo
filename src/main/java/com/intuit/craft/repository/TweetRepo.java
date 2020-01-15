package com.intuit.craft.repository;

import com.intuit.craft.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepo extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByUserId(Long userId);
    List<Tweet> findAllByUserIdIn(List<Long> userIds);
    List<Tweet> findTop100ByUserIdInOrderByIdDesc(List<Long> userIds);
}
