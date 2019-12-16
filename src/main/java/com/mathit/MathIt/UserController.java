package com.mathit.MathIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private
    UserRepository userRepository;

    @Autowired
    private
    SequenceGeneratorService sequenceGeneratorService;

//    Find if User exists for the given credentials
    @RequestMapping("/get")
    public ResponseEntity find(@RequestParam String username, @RequestParam String password){
        User user = null;
        if((user = userRepository.findByUsername(username)) == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if(user.password.equals(password)){
            return new ResponseEntity(user.getId(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

//    Signup End point for Registering new User
    @RequestMapping("/signup")
    public ResponseEntity signUp(@RequestParam Optional<String> fullName, @RequestParam String username, @RequestParam String password){
        User user = new User(username, password);
        Integer next_id = sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);

        user.setId(next_id.toString());
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
