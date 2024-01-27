package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {
    final UserRepository userRepository;
    final TweetRepository tweetRepository;

    TweetService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public Optional<TweetModel> createTweet(TweetDTO tweetDTO){
        Long userId = tweetDTO.getUserId();
        if(userId == null){
            return Optional.empty();
        }
        Optional<UserModel> user = userRepository.findById(userId);
        if(!user.isPresent()){
            return Optional.empty();
        }
        TweetModel newTweet = new TweetModel(tweetDTO, user.get());
        return Optional.of(tweetRepository.save((newTweet)));
    }

    public List<TweetModel> getTweets(){
        return tweetRepository.findAll();
    }

    public Optional<List<TweetModel>> getTweetsByUserId(Long userId){
        if(userId == null){
            return Optional.empty();
        }
        Optional<UserModel> user = userRepository.findById(userId);
        if(!user.isPresent()){
            return Optional.empty();
        }
        return Optional.of(tweetRepository.getByUserId(userId));
    }
}
