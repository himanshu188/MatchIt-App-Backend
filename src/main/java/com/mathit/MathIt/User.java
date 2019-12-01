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

    User(String first, String last){
        this.username = first;
        this.password = last;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }
    public Integer getId(){
        return id;
    }
}
