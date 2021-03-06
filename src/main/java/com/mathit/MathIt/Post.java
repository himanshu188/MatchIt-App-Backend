package com.mathit.MathIt;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Post Entity as per the Database in MongoDB
@Data
@Document(collection = "posts")
public class Post {
    @Id
    Integer id;
    String title;
    String content;
    String photo;
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    Post(){

    }

    Post(String first, String last){
        this.title = first;
        this.content = last;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }
    public Integer getId(){
        return id;
    }
}
