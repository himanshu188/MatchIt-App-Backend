package com.mathit.MathIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private
    UserRepository userRepository;
    @RequestMapping("/get")
    public ResponseEntity find(@RequestParam String username, @RequestParam String password){
        if(userRepository.findByUsername(username) == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping("/put")
    public void put(@RequestParam Integer id, @RequestParam String name, @RequestParam String password){
       userRepository.save(new User(id, name, password));
    }
//    TODO: Put Mapping for any Error
    @RequestMapping("/check")
    public ResponseEntity test(){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
