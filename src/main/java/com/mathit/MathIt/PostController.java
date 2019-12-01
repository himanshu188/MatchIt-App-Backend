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
        List<Post> posts = postRepository.findAll();
        return posts;
    }
//    @RequestMapping("/put")
//    public void put(@RequestParam Integer id, @RequestParam String name, @RequestParam String password){
//       postRepository.save(new User(name, password));
//    }
////    TODO: Put Mapping for any Error
//    @RequestMapping("/check")
//    public ResponseEntity test(){
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
}
