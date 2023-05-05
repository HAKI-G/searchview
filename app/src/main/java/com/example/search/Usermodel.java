package com.example.search;

import java.io.Serializable;

public class Usermodel implements Serializable {

    private String username;

    public Usermodel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
