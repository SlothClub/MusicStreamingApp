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
    public String description;
    public ImageView background;

    public MyViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.card_title);
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
                extra.putString("description", description);
//                Bitmap bitmap = BitmapFactory.decodeResource(background.getResources(), R.drawable.taylor_grammy);
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                byte[] b = baos.toByteArray();                    // Convert to bitmap to send over to expand
//                extra.putByteArray("background", b);
                expandCardView.putExtra("background", background.getDrawingCache());
                expandCardView.putExtras(extra);
                context.startActivity(expandCardView);
            }
        });
    }
}