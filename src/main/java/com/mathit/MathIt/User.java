package com.mathit.MathIt;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    Integer id;
    String username;
    String password;

    User(){

    }

    User(Integer id, String first, String last){
        this.id = id;
        this.username = first;
        this.password = last;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    public Integer getId(){
        return id;
    }
}
