package com.example.somaiyaclassroombookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText svvNetId,pwd;
    Button loginBtn;
    TextView RegisterNow;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Intent i4 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i4);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        svvNetId = findViewById(R.id.svvNetId);
        pwd = findViewById(R.id.pwd);
        RegisterNow = findViewById(R.id.RegisterNow);

        loginBtn = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.progressBar);

        RegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(), register.class);
                startActivity(i2);
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LsvvNetId, password;

                progressBar.setVisibility(View.VISIBLE);
                LsvvNetId = String.valueOf(svvNetId.getText());
                password = String.valueOf(pwd.getText());

                if(TextUtils.isEmpty(LsvvNetId)){
                    Toast.makeText(login.this, "Enter SVVNetId", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword (LsvvNetId, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete (@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent i3 = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(i3);
                                    finish();
                                } else {
                                    Toast.makeText(login.this,"Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


    }
}