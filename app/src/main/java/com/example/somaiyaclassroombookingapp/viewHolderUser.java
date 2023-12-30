package com.example.somaiyaclassroombookingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class viewHolderUser extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public viewHolderUser(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title);
        imageView = itemView.findViewById(R.id.header_image);
    }
}
