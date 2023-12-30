package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class getStarted3 extends AppCompatActivity {

    TextView titleTxt3,contentTxt3;
    ImageView graphic3;
    Button gsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started3);

        titleTxt3 = findViewById(R.id.titleTxt3);
        contentTxt3 = findViewById(R.id.contentTxt3);
        graphic3 = findViewById(R.id.graphic3);
        gsBtn = findViewById(R.id.gsBtn);

        gsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getStarted3.this, introSplash.class);
                startActivity(i1);
            }
        });

    }

}
