package com.example.hericxon.reprohealth.user;

/**
 * Created by HERICXON on 06-Jun-18.
 */

public class UserCredentials {
    public long userId;
    public String username;
    public String password;

    public UserCredentials(long userId, String username, String password){
        this.userId=userId;
        this.username=username;
        this.password=password;
    }
}
