package com.mathit.MathIt;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, Integer> {
//    Repository to Connect the Controller to MongoDB Repo automatically
}
