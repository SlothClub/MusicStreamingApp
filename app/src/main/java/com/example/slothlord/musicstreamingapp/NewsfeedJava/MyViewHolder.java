package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

/**
 * Created by Luis on 11/18/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView description;
    public ImageView background;

    public MyViewHolder(View view) {
        super(view);


        title = (TextView) view.findViewById(R.id.card_title);
        description = (TextView) view.findViewById(R.id.card_description);
        background = (ImageView) view.findViewById(R.id.background);
        background.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                title.setText("MPLV");
            }

        });


    }


}