package com.intuit.craft.controller;

import com.intuit.craft.dto.FriendshipDTO;
import com.intuit.craft.dto.UsersDTO;
import com.intuit.craft.service.FriendshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class FriendshipResource {

    private final Logger log = LoggerFactory.getLogger(FriendshipService.class);

    @Autowired
    FriendshipService friendshipService;

    @GetMapping(path = "friendship", produces = "application/json")
    public ResponseEntity<List<FriendshipDTO>> findAllFollowing() {
        log.debug("to get all folloings from the friendship table.");
        List<FriendshipDTO> followings= friendshipService.findAllFollowing();
        return new ResponseEntity(followings, HttpStatus.OK);
    }

    @GetMapping(path = "friendship/followers", produces = "application/json")
    public ResponseEntity<List<FriendshipDTO>> findFollowers(@RequestParam long user_id) {
        log.debug("to get all followers from the friendship table.");
        List<Long> followers= friendshipService.getAllFollower(user_id);
        return new ResponseEntity(followers, HttpStatus.OK);
    }
    @GetMapping(path = "friendship/followings", produces = "application/json")
    public ResponseEntity<List<FriendshipDTO>> findFollowings(@RequestParam long user_id) {
        log.debug("to get all followings from the friendship table.");
        List<Long> followings= friendshipService.getAllFollows(user_id);
        return new ResponseEntity(followings, HttpStatus.OK);
    }

    @PostMapping(path = "friendship", produces = "application/json")
    public void follow(@RequestBody FriendshipDTO friendshipDTO){
        friendshipService.follow(friendshipDTO);
    }

    @DeleteMapping(path = "friendship", produces = "application/json")
    public void unfollow(@RequestBody FriendshipDTO friendshipDTO){
        friendshipService.unfollow(friendshipDTO);
    }

}
