package com.intuit.craft.controller;

import com.intuit.craft.dto.FriendshipDTO;
import com.intuit.craft.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class FriendshipResource {

    @Autowired
    FriendshipService friendshipService;

    @PostMapping(path = "follow", produces = "application/json")
    public void follow(@RequestBody FriendshipDTO friendshipDTO){
        friendshipService.follow(friendshipDTO);
    }

    @PostMapping(path = "unfollow", produces = "application/json")
    public void unfollow(@RequestBody FriendshipDTO friendshipDTO){
        friendshipService.unfollow(friendshipDTO);
    }
}
