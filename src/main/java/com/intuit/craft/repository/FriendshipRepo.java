package com.intuit.craft.repository;

import com.intuit.craft.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
    List<Friendship> findAllByFromUserId(Long userId);
    List<Friendship> findAllByToUserId(Long userId);
    List<Friendship> findAllByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    @Modifying
    @Transactional
    @Query(value = "delete from Friendship n where n.fromUserId = ?1 and n.toUserId = ?2")
    void deleteByFromUserIdAndToUserId(Long fromUserId, Long toUserId);
}
