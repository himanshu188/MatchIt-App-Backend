package com.mathit.MathIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private
    PostRepository postRepository;

    private List<Entity> entities;
    @RequestMapping("/get")
    public List<Post> find(){
//        Get all the Posts from Database
        List<Post> posts = postRepository.findAll();
        return posts;
    }
}
