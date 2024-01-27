package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;


@RestController
@RequestMapping("/tweets")
public class TweetController {
    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO tweetDTO){
        Optional<TweetModel> newTweet = tweetService.createTweet(tweetDTO);
        if(!newTweet.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId is not valid");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newTweet);
    }

    @GetMapping
    public ResponseEntity<List<TweetModel>> getTweets() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getTweets());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getTweetsByUserId(@PathVariable Long userId) {
        Optional<List<TweetModel>> userTweets = tweetService.getTweetsByUserId(userId);
        if(!userTweets.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId is not valid");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getTweetsByUserId(userId));
    }
}
