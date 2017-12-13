package com.example.slothlord.musicstreamingapp.RetrofitResources;

import com.example.slothlord.musicstreamingapp.POJO.NewsArticle;
import com.example.slothlord.musicstreamingapp.POJO.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public interface APIInterface {

    @GET("/createSession.php")
    Call<User> authenticateUser(@Query("email") String email, @Query("password") String password);

    @GET("/addUser.php")
    Call<User> createUser(@Query("email") String email, @Query("password") String password);

    @GET("/getnews.php")
    Call<List<NewsArticle>>  getNews();
}
