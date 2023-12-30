package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class bookingFailure extends AppCompatActivity {

    ImageView imageViewF;
    TextView bFailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_failure);

        imageViewF = findViewById(R.id.imageViewF);
        bFailTxt = findViewById(R.id.bFailTxt);
    }
}