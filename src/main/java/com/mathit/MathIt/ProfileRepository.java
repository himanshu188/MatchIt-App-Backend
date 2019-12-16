package com.mathit.MathIt;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {
//    Profile Repository to connect Controller to MongoDB
    Optional<Profile> findById(String Id);
}
