package com.mathit.MathIt;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
//    Find User Name By Name of the User
    public User findByUsername(String name);
}
