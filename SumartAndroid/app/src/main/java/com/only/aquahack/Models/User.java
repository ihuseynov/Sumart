package com.only.aquahack.Models;

/**
 * Created by only_ on 7/3/2020.
 */

public class User {

    private String userId;
    private String password;

    public User(String userId,String password){

        this.password = password;
        this.userId = userId;

    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
