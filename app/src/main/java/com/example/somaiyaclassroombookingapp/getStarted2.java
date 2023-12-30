package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class getStarted2 extends AppCompatActivity {

    TextView titleTxt2,contentTxt2;
    ImageView graphic2;
    ImageButton arrowRBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started2);

        titleTxt2 = findViewById(R.id.titleTxt2);
        contentTxt2 = findViewById(R.id.contentTxt2);
        graphic2 = findViewById(R.id.graphic2);
        arrowRBtn2 = findViewById(R.id.arrowRBtn2);

        arrowRBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getStarted2.this, getStarted3.class);
                startActivity(i1);
            }
        });

    }

}