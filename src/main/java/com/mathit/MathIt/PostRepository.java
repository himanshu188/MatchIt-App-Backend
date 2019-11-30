package com.mathit.MathIt;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, Integer> {
//    public User findByUsername(String name);
}
