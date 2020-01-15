package com.intuit.craft.repository;

import com.intuit.craft.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
    List<Friendship> findAllByFromUserId(Long userId);
}
