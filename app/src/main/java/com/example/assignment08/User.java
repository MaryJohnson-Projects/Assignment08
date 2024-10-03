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
    String state;
    String dob;
    String maritalStatus;
    String education;

    public User(String name, String email, String age, String state, String dob,
                String maritalStatus, String education){
        this.name = name;
        this.email = email;
        this.age = age;
        this.state = state;
        this.dob = dob;
        this.maritalStatus = maritalStatus;
        this.education = education;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAge(String age){
        this.age = age;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public void setEducation(String education){
        this.education = education;
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

    public String getState(){
        return state;
    }

    public String getDob(){
        return dob;
    }

    public String getMaritalStatus(){
        return maritalStatus;
    }

    public String getEducation(){
        return education;
    }

}

