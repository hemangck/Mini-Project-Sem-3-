package com.example.somaiyaclassroombookingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myUserAdapter extends RecyclerView.Adapter<viewHolderUser> {

    private List<dataModelUser> dataList;
    private Context context;

    public myUserAdapter(Context context, List<dataModelUser> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    private ImageView headerImage;
    @Override
    public viewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user, parent, false);
        return new viewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(viewHolderUser holder, int position) {
        dataModelUser data = dataList.get(position);
        holder.textView.setText(data.getText());

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), data.getImageResource());
        holder.imageView.setImageBitmap(bitmap);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
