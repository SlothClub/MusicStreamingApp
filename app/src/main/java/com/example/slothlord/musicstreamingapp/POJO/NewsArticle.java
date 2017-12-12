package com.example.slothlord.musicstreamingapp.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public class NewsArticle {

    @SerializedName("article_text")
    public String article_text;

    @SerializedName("article_image")
    public String image_path;

    public String articleText() {
        return article_text;
    }

    public String getImagePath() {
        return image_path;
    }

    public String toString() {
        return "[NewsArticle: [description : " + this.article_text + " imagePath : " + this.image_path + "]]";
    }
}
