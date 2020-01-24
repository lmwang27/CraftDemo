package com.intuit.craft.service;

import com.intuit.craft.dto.ProfileDTO;
import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.entity.Friendship;
import com.intuit.craft.entity.Tweet;
import com.intuit.craft.entity.Users;
import com.intuit.craft.repository.FriendshipRepo;
import com.intuit.craft.repository.TweetRepo;
import com.intuit.craft.repository.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * for user register, login
 **/

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    UsersRepo userRepository;
    @Autowired
    TweetRepo tweetRepo;
    @Autowired
    FriendshipRepo friendShipRepo;

    public Users registerUser(UsersDTO userDTO) {
        if(isExistOrNot(userDTO)){
            log.debug("created new user failed, a user named "+ userDTO.getUsername()+" already existed.");
            return new Users();
        }
        Users newUser = new Users();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPicUrl(userDTO.getPicUrl());
        newUser.setFollowers(0);
        newUser.setFollowing(0);
        newUser.setTweets(0);
        userRepository.saveAndFlush(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    public Boolean isExistOrNot(UsersDTO usersDTO){
        Optional<Users> user = userRepository.findByUsername(usersDTO.getUsername());
        return user.isPresent();
    }

    public List<ProfileDTO> findAllUsers(){
        List<Users> results = userRepository.findAll();
        ArrayList<ProfileDTO> users = new ArrayList<>();
        for(Users user : results){
            ProfileDTO u = new ProfileDTO();
            u.setId(user.getId());
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPicUrl(user.getPicUrl());
            u.setCreated_at(user.getCreatedAt());
            u.setFollowers(user.getFollowers());
            u.setFollowing(user.getFollowing());
            u.setTweets(user.getTweets());
            users.add(u);
        }
        return users;
    }

    /**
     * find the user's profile by name.
    **/
    public ProfileDTO findByUserName( String usrname){
        List<Users> results = userRepository.findAllByUsername(usrname);


        if(results.size()>0) {
            ProfileDTO user = new ProfileDTO();
            user.setId(results.get(0).getId());
            user.setUsername(results.get(0).getUsername());
            user.setEmail(results.get(0).getEmail());
            user.setPicUrl(results.get(0).getPicUrl());
            user.setCreated_at(results.get(0).getCreatedAt());
            user.setFollowers(results.get(0).getFollowers());
            user.setFollowing(results.get(0).getFollowing());
            user.setTweets(results.get(0).getTweets());

            log.debug("gather Information for User: {}", results.get(0));

            return user;
        }

        log.debug("No Information for Input User: {}", usrname);
        return null;
    }
}
