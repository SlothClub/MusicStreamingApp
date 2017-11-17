package com.example.slothlord.musicstreamingapp.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public class User {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("id")
    public String id;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}