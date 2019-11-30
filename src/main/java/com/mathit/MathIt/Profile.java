package com.mathit.MathIt;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "profile")
public class Profile {

    @Transient
    public static  final String SEQUENCE_NAME ="profile_section";

    @Id
    String id;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    Integer seq;

    String name;
    String tag;
    String interest;
    String city;

    Binary binary;
    String movies;
    String sports;
    String food;
    Integer age;
    String social_media;

    Profile(){

    }


    public Binary getBinary() {
        return binary;
    }

    public void setBinary(Binary binary) {
        this.binary = binary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSocial_media() {
        return social_media;
    }

    public void setSocial_media(String social_media) {
        this.social_media = social_media;
    }

    Profile(String name, String tag, String interest, String city, String movies
            , String sports, String food, String social_media, Integer age, Binary binary){
        this.name = name;
        this.tag = tag;
        this.interest = interest;
        this.city = city;
        this.movies = movies;
        this.sports = sports;
        this.food = food;
        this.social_media = social_media;
        this.age = age;
        this.binary = binary;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
