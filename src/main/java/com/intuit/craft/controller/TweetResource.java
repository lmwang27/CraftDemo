package com.intuit.craft.controller;

import com.intuit.craft.dto.TweetDTO;
import com.intuit.craft.service.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class TweetResource {

    private final Logger log = LoggerFactory.getLogger(TweetResource.class);

    @Autowired
    private TweetService tweetService;

    @GetMapping(path = "feed", produces = "application/json")
    public ResponseEntity<List<TweetDTO>> feed(@RequestParam Long user_id) {
        log.debug("to get all the feed for user:{} from the table.", user_id);
        List<TweetDTO> tweetDTOList = tweetService.feed(user_id);
        return new ResponseEntity<>(tweetDTOList, HttpStatus.OK);
    }

    @PostMapping(path = "tweet", produces = "application/json")
    public void tweet(@RequestBody TweetDTO tweetDTO, @RequestParam Long user_id) {
        tweetDTO.setUser_id(user_id);
        tweetService.tweet(tweetDTO);
    }
}
