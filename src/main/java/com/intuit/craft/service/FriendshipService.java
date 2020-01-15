package com.intuit.craft.service;

import com.intuit.craft.dto.FriendshipDTO;
import com.intuit.craft.entity.Friendship;
import com.intuit.craft.repository.FriendshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Follow/Unfollow
 **/
@Service
@Transactional
public class FriendshipService {
    @Autowired
    FriendshipRepo friendshipRepo;

    public void follow(FriendshipDTO friendshipDTO){
        if (friendshipDTO == null) {
            return;
        }
        Friendship friendship = new Friendship();
        friendship.setFromUserId(friendshipDTO.getFrom_user_id());
        friendship.setToUserId(friendshipDTO.getTo_user_id());
        friendshipRepo.saveAndFlush(friendship);
    }

    public void unfollow(FriendshipDTO friendshipDTO){
        if (friendshipDTO == null) {
            return;
        }
        Friendship friendship = new Friendship();
        friendship.setFromUserId(friendshipDTO.getFrom_user_id());
        friendship.setToUserId(friendshipDTO.getTo_user_id());
        friendshipRepo.delete(friendship);
    }

    public List<Long> getAllFollows(Long userId){
        List<Friendship> friendshipList = friendshipRepo.findAllByFromUserId(userId);
        List<Long> follows = new ArrayList<>();
        for (Friendship friendship : friendshipList) {
            follows.add(friendship.getToUserId());
        }
        return follows;
    }
}
