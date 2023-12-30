package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    EditText svvId,password;
    Button loginBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        svvId = findViewById(R.id.svvId);
        password = findViewById(R.id.password);
        loginBtn2 = findViewById(R.id.loginBtn2);

        FirebaseApp.initializeApp(this);

//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        String svvIdVar = svvId.getText().toString();
//        String passwordVar = password.getText().toString();

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    private void login(){

        FirebaseAuth auth = FirebaseAuth.getInstance();
        String svvIdVar = svvId.getText().toString();
        String passwordVar = password.getText().toString();

        auth.signInWithEmailAndPassword(svvIdVar, passwordVar)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful, do something like navigating to the main activity.
                        Intent i1 = new Intent(loginPage.this, MainActivity.class);
                        startActivity(i1);
                    } else {
                        // Login failed, handle the error.
                        String error = task.getException().getMessage();
                        Toast.makeText(this, "Login failed ! \n due to " + error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}