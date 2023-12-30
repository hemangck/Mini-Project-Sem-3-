package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.widget.ImageView;

public class bookSuccess extends AppCompatActivity {
    ImageView mImgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_success);

        // binding ui to activity
        mImgCheck = (ImageView) findViewById(R.id.imageView);

        ((Animatable) mImgCheck.getDrawable()).start();

    }
}