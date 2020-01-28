package com.intuit.craft.service;

import com.intuit.craft.entity.Users;
import com.intuit.craft.newsfeed.NewsFeedHelper;
import com.intuit.craft.dto.FriendshipDTO;
import com.intuit.craft.entity.Friendship;
import com.intuit.craft.repository.FriendshipRepo;
import com.intuit.craft.repository.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private final Logger log = LoggerFactory.getLogger(FriendshipService.class.getName());

    @Autowired
    FriendshipRepo friendshipRepo;

    @Autowired
    NewsFeedHelper newsFeedHelper;

    @Autowired
    UsersRepo usersRepo;

    @Value("${craft.enable.newsfeed}")
    boolean newsFeedEnabled;


    public List<FriendshipDTO> findAllFollowing(){
        log.debug("Collect all friendship info in friendship table!");

        List<Friendship> results = friendshipRepo.findAll();
        ArrayList<FriendshipDTO> friends = new ArrayList<>();
        for(Friendship friend : results){
            FriendshipDTO u = new FriendshipDTO();
            u.setId(friend.getId());
            u.setFrom_user_id(friend.getFromUserId());
            u.setTo_user_id(friend.getToUserId());
            u.setCreated_at(friend.getCreatedAt());
            friends.add(u);
        }
        return friends;
    }
    public void follow(FriendshipDTO friendshipDTO){
        if (friendshipDTO == null) {
            return;
        }
        List<Friendship> isInTbl = friendshipRepo.findAllByFromUserIdAndToUserId(friendshipDTO.getFrom_user_id(),
                                                                                      friendshipDTO.getTo_user_id());
        if(isInTbl==null){
            log.debug("Friendship already exist for :{},{}", friendshipDTO.getFrom_user_id(),friendshipDTO.getTo_user_id());
            return;
        }
        Friendship friendship = new Friendship();
        friendship.setFromUserId(friendshipDTO.getFrom_user_id());
        friendship.setToUserId(friendshipDTO.getTo_user_id());
        friendshipRepo.saveAndFlush(friendship);

        Users userFrom = usersRepo.findAllById(friendship.getFromUserId());
        Users userTo = usersRepo.findAllById(friendship.getToUserId());

        log.debug("Updating Users Info in users table!");

        if(userFrom != null){
            userFrom.setFollowing(userFrom.getFollowing()+1);
            usersRepo.saveAndFlush(userFrom);
        }
        if(userTo != null){
            userTo.setFollowers(userTo.getFollowers()+1);
            usersRepo.saveAndFlush(userTo);
        }

        if (newsFeedEnabled) {
            newsFeedHelper.follow(friendship);
        }
    }

    public void unfollow(FriendshipDTO friendshipDTO){
        if (friendshipDTO == null) {
            return;
        }

        List<Friendship> isExist = friendshipRepo.findAllByFromUserIdAndToUserId(friendshipDTO.getFrom_user_id(),
                                                                                      friendshipDTO.getTo_user_id());
        if(isExist == null){
            log.debug("Friendship is not existing for :{},{}", friendshipDTO.getFrom_user_id(),friendshipDTO.getTo_user_id());
            return ;
        }
        Friendship friendship = new Friendship();
        friendship.setFromUserId(friendshipDTO.getFrom_user_id());
        friendship.setToUserId(friendshipDTO.getTo_user_id());
        friendshipRepo.deleteByFromUserIdAndToUserId(friendshipDTO.getFrom_user_id(),friendshipDTO.getTo_user_id());
        friendshipRepo.flush();

        Users to= usersRepo.findAllById(friendshipDTO.getTo_user_id());
        Users from = usersRepo.findAllById(friendshipDTO.getFrom_user_id());

        if(from != null){
            from.setFollowing(from.getFollowing()-1);
            usersRepo.saveAndFlush(from);
        }
        if(to != null){
            to.setFollowers(to.getFollowers()-1);
            usersRepo.saveAndFlush(to);
        }
        if (newsFeedEnabled) {
            newsFeedHelper.unFollow(friendship);
        }

    }

    public List<Long> getAllFollows(Long userId){

        List<Friendship> friendshipList = friendshipRepo.findAllByFromUserId(userId);
        if (friendshipList == null ||friendshipList.size()==0)
            return new ArrayList<Long>();

        List<Long> follows = new ArrayList<>();
        for (Friendship friendship : friendshipList) {
            follows.add(friendship.getToUserId());
        }
        return follows;
    }

    public List<Long> getAllFollower(Long userId) {
        List<Friendship> friendshipList = friendshipRepo.findAllByToUserId(userId);
        if (friendshipList == null ||friendshipList.size()==0)
            return new ArrayList<Long>();
        List<Long> followers = new ArrayList<>();
        for (Friendship friendship : friendshipList) {
            followers.add(friendship.getFromUserId());
        }
        return followers;
    }
}
