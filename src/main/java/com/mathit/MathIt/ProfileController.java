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
////    TODO: Put Mapping for any Error
//    @RequestMapping("/check")
//    public ResponseEntity test(){
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
}
