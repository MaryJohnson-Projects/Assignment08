/*
    Assignment 07
    User.java
    Mary Johnson & Cayden Renegar
    Group 18
 */

package com.example.assignment08;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String email;
    String age;
    String country;
    String dob;

    public User(String name, String email, String age, String country, String dob){
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
        this.dob = dob;
    }

    public void getName(String name){
        this.name = name;
    }

    public void getEmail(String email){
        this.email = email;
    }

    public void getAge(String age){
        this.age = age;
    }

    public void getCountry(String country){
        this.country = country;
    }

    public void getDob(String dob){
        this.dob = dob;
    }


    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getAge(){
        return age;
    }

    public String getCountry(){
        return country;
    }

    public String getDob(){
        return dob;
    }

}

