package com.example.somaiyaclassroombookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.widget.Toast;

public class dataModel extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_model);



        // Initialize FirebaseApp if necessary
        if(FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        // Assuming your database structure is Users -> 0 -> userID26 -> name
        mDatabase = FirebaseDatabase.getInstance().getReference().child("miniproject-f065b-default-rtdb").child("users").child("0").child("userID26").child("name");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the value from the dataSnapshot and display it in a toast message
                if (dataSnapshot.exists()) {
                    String value = dataSnapshot.getValue(String.class);
                    Toast.makeText(dataModel.this, "Value from Firebase: " + value, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(dataModel.this, "No such data exists in the database.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting data failed, log a message
                Toast.makeText(dataModel.this, "Failed to read value from Firebase.", Toast.LENGTH_SHORT).show();
                // Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });

    }
}
