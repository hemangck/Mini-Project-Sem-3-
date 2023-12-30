package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class introSplash extends AppCompatActivity {

    TextView wlcmText,instName;
    ImageView instLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_splash);

        wlcmText = findViewById(R.id.wlcmText);
        instName = findViewById(R.id.instName);
        instLogo = findViewById(R.id.instLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome = new Intent(introSplash.this, userRoles.class);
                startActivity(iHome);
                finish();
            }
        },4000);
    }

}
