package com.example.somaiyaclassroombookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class homePage extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView emailId, nameTV, roleTV, IdTV;
    Button bookButton;
    DatabaseReference mDatabase; // mDatabase - member database - convention
    public String name,svvId,role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // binding fields
        emailId = findViewById(R.id.emailId);
        nameTV = findViewById(R.id.nameTV);
        roleTV = findViewById(R.id.roleTV);
        IdTV = findViewById(R.id.IdTV);
        bookButton = findViewById(R.id.bookButton);

        // for firebase authentication functionality
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // checking conditions whether user is null
        if (user == null) {
            Intent loginIntent = new Intent(homePage.this, loginF.class);
            startActivity(loginIntent);
            finish();
        } else {
            emailId.setText(user.getEmail());
        }

        // storing email of user in string
        String emailToFetch = user.getEmail();

        // getting reference of parent node users of firebase realtime database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        // defining query
        Query query = mDatabase.orderByChild("email").equalTo(emailToFetch);

        // set a listener to retrieve the data by using query
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // retrieve the specific data
                    name = snapshot.child("name").getValue(String.class);
                    role = snapshot.child("role").getValue(String.class);
                    svvId = snapshot.child("svvId").getValue(String.class);

                    // updating the UI with the fetched data
                    nameTV.setText(name);
                    roleTV.setText(role);
                    IdTV.setText(svvId);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
            }
        });

        // applying setonclicklistenr and performing task - intent and passing values through it
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homePage.this, from1.class);
                intent.putExtra("NAME",name);
                intent.putExtra("SVVID",svvId);
                intent.putExtra("ROLE",role);
                startActivity(intent);
            }
        });
    }
}
