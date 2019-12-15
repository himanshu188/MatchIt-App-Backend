package com.mathit.MathIt;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private
    ProfileRepository profileRepository;

    @Autowired
    private AmazonClient amazonClient;

    @Autowired
    private
    SequenceGeneratorService sequenceGeneratorService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Optional<Profile> findById(@PathVariable("id") String id){
        return profileRepository.findById(id);
    }


    @RequestMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestParam Optional<String> tag, @RequestParam Optional<String> interest, @RequestParam Optional<String> city, @RequestParam Optional<String> movies
            , @RequestParam Optional<String> sports, @RequestParam Optional<String> food, @RequestParam Optional<String> social_media){
        Optional<Profile> profile = profileRepository.findById(id);
        if(profile.isPresent()) {
            Profile profile1 = profile.get();
            if(tag.isPresent()){
                profile1.tag = tag.get();
            }
            if(interest.isPresent()){
                profile1.interest = interest.get();
            }
            if(city.isPresent()){
                profile1.city = city.get();
            }
            if(movies.isPresent()){
                profile1.movies = movies.get();
            }
            if(sports.isPresent()){
                profile1.sports = sports.get();
            }
            if(food.isPresent()){
                profile1.food = food.get();
            }
            if(social_media.isPresent()){
                profile1.social_media = social_media.get();
            }
        }
        if(profile.isPresent()){
            profileRepository.save(profile.get());
        }
    }

    @RequestMapping("/create")
    public void create(@RequestParam String name){
        Profile profile = null;
        profile = new Profile(name);
        Integer next_id = sequenceGeneratorService.generateSequence(Profile.SEQUENCE_NAME);
        profile.setId(next_id.toString());
        profileRepository.save(profile);
    }
    @RequestMapping("/put")
    public void put(@RequestParam String name, @RequestParam String tag, @RequestParam String interest, @RequestParam String city, @RequestParam String movies
            , @RequestParam String sports, @RequestParam String food, @RequestParam String social_media, @RequestParam Integer age, MultipartFile file){
        Profile profile = null;
            profile = new Profile(name, tag, interest, city, movies
                                             , sports, food, social_media, age, amazonClient.uploadFile(file));

        Integer next_id = sequenceGeneratorService.generateSequence(Profile.SEQUENCE_NAME);
        profile.setId(next_id.toString());
       profileRepository.save(profile);
    }
}
