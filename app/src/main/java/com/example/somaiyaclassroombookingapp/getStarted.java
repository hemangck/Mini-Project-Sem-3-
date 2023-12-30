package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class getStarted extends AppCompatActivity {

    TextView titleTxt,contentTxt;
    ImageView graphic1;
    ImageButton arrowRBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        titleTxt = findViewById(R.id.titleTxt);
        contentTxt = findViewById(R.id.contentTxt);
        graphic1 = findViewById(R.id.graphic1);
        arrowRBtn = findViewById(R.id.arrowRBtn);

        arrowRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getStarted.this, getStarted2.class);
                startActivity(i1);
            }
        });

    }
}