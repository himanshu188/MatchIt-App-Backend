package com.mathit.MathIt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathItController {
    @RequestMapping("/test")
    public String testing(){
        return "hello world";
    }
}
