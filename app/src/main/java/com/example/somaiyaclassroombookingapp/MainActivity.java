package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button logout,btnSend,btnDecline;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
//    String current_state = "nothing happened";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        textView = findViewById(R.id.textview);
        btnSend = findViewById(R.id.btnSend);
        btnDecline = findViewById(R.id.btnDecline);
        user = auth.getCurrentUser();
        String email = user.getEmail().toString();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

        final String userID = getIntent().getStringExtra("email");

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), loginPage.class);
                startActivity(intent);
                finish();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendRequest(userID);

            }
        });

        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

//    private void sendRequest(String user) {
//        if(current_state.equals("nothing happened"));
//    }
}