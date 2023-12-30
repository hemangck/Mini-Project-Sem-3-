package com.example.somaiyaclassroombookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginF extends AppCompatActivity {
    EditText username,password;
    Button loginButton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_f);

        // getting instance of firebase authentication
        mAuth = FirebaseAuth.getInstance();

        // binding fields
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        // applying setonclicklistenr on button and performing task - doing authencation by using firebase
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String pwd = password.getText().toString();

               if (email.isEmpty() && pwd.isEmpty()) {
            Toast.makeText(loginF.this, "Please enter both email and password.", Toast.LENGTH_SHORT).show();
        } else {
                   mAuth.signInWithEmailAndPassword(email, pwd)
                           .addOnCompleteListener(loginF.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                       Toast.makeText(loginF.this, "Sign in successful.", Toast.LENGTH_SHORT).show();
                                       Intent i1 = new Intent(loginF.this, homePage.class);
                                       startActivity(i1);
                                   } else {
                                       Toast.makeText(loginF.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
               }
            }
        });

    }
}
