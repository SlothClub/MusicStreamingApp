package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;
import android.util.Log;

import com.example.slothlord.musicstreamingapp.POJO.NewsArticle;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by slothlord on 11/6/17.
 */

public class NewsFeedController {

    volatile Context cxt;
    ArrayList<NewsArticle> articles = new ArrayList<NewsArticle>();

    public NewsFeedController(Context cxt) { this.cxt = cxt; }

    public ArrayList<NewsArticle> retrieveNews() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<NewsArticle>> call = apiInterface.getNews();

        call.enqueue(new Callback<List<NewsArticle>>() {
            @Override
            public void onResponse(Call<List<NewsArticle>> call, Response<List<NewsArticle>> response) {
                Log.d("TAG", response.code()+"");

                List<NewsArticle> articles = response.body();

                for (NewsArticle article: articles) {
                    System.out.println(article.toString());
                }
            }

            @Override
            public void onFailure(Call<List<NewsArticle>> call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });

        return articles;
    }
}
