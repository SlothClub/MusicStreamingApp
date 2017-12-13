package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsFeedExpandActivity extends AppCompatActivity {

    private ImageView background;
    private TextView title;
    private TextView description;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_expand);

        background = (ImageView) findViewById(R.id.ex_image);
        title = (TextView) findViewById(R.id.ex_title);
        description = (TextView) findViewById(R.id.ex_description);


        title.setText(getIntent().getExtras().getString("title"));
        description.setText(getIntent().getExtras().getString("description"));
        image = getIntent().getExtras().getParcelable("background");
        background.setImageBitmap(image);

    }
}
