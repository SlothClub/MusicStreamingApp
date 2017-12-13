package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by Luis on 11/18/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView description;
    public ImageView background;
    private Bitmap image;

    public MyViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.card_title);
        description = (TextView) v.findViewById(R.id.card_description);
        background = (ImageView) v.findViewById(R.id.backgroundId);
        background.buildDrawingCache();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CARD", title.getText().toString());
                Context context = v.getContext();
                Intent expandCardView = new Intent(context, NewsFeedExpandActivity.class);
                Bundle extra = new Bundle();
                extra.putString("title", title.getText().toString());
                extra.putString("description", description.getText().toString());
                image = background.getDrawingCache();
                extra.putParcelable("background", image);
                expandCardView.putExtras(extra);
                context.startActivity(expandCardView);
            }
        });
    }
}