package com.mathit.MathIt;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    public User findByUsername(String name);
}
