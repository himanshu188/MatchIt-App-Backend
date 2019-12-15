package com.mathit.MathIt;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Transient
    public static  final String SEQUENCE_NAME ="user_section";

    @Id
    String id;
    String username;
    String password;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    Integer seq;
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

    public void setId(String id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }
}
